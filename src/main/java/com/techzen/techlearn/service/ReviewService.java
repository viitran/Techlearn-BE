package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.ReviewRequestDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.dto.response.ReviewResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    ReviewResponseDTO getReviewById(Long id);

    ReviewResponseDTO addReview(ReviewRequestDTO request);

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO request);

    void deleteReview(Long id);

    PageResponse<?> getAllReview(int page, int pageSize);
}
