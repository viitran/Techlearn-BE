package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.ReviewRequestDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.dto.response.ReviewResponseDTO;
import com.techzen.techlearn.entity.ReviewEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.ReviewMapper;
import com.techzen.techlearn.repository.ReviewRepository;
import com.techzen.techlearn.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDTO getReviewById(Long id) {
        ReviewEntity review = reviewRepository.findReviewById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return reviewMapper.toReviewResponseDTO(review);
    }

    @Override
    public ReviewResponseDTO addReview(ReviewRequestDTO request) {
        ReviewEntity review = reviewMapper.toReviewEntity(request);
        review.setIsDeleted(false);
        review = reviewRepository.save(review);
        return reviewMapper.toReviewResponseDTO(review);
    }

    @Override
    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO request) {
        reviewRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        var reviewMap = reviewMapper.toReviewEntity(request);
        reviewMap.setId(id);
        reviewMap.setIsDeleted(false);
        return reviewMapper.toReviewResponseDTO(reviewRepository.save(reviewMap));
    }

    @Override
    public void deleteReview(Long id) {
        var review = reviewRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        review.setIsDeleted(true);
        reviewRepository.save(review);
    }

    @Override
    public PageResponse<?> getAllReview(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
        Page<ReviewEntity> reviews = reviewRepository.findAll(pageable);
        List<ReviewResponseDTO> list = reviews.map(reviewMapper::toReviewResponseDTO).stream().collect(Collectors.toList());
        return PageResponse.builder()
                .page(page)
                .pageSize(pageSize)
                .totalPage(reviews.getTotalPages())
                .items(list)
                .build();
    }
}
