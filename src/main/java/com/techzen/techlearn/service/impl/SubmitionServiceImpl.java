package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.dto.response.ReviewResponseDTO;
import com.techzen.techlearn.entity.AssignmentEntity;
import com.techzen.techlearn.entity.SubmitionEntity;
import com.techzen.techlearn.entity.UserEntity;
import com.techzen.techlearn.enums.SubmitStatus;
import com.techzen.techlearn.mapper.ReviewMapper;
import com.techzen.techlearn.repository.AssignmentRepository;
import com.techzen.techlearn.repository.SubmitionRepository;
import com.techzen.techlearn.repository.UserRepository;
import com.techzen.techlearn.service.SubmitionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubmitionServiceImpl implements SubmitionService {

    SubmitionRepository submitionRepository;
    UserRepository userRepository;
    AssignmentRepository assignmentRepository;
    ReviewMapper reviewMapper;

    @Override
    public void addSubmit(String linkGithub, String resultReview) {
        Optional<UserEntity> userEntity = Optional.of(userRepository.findUserById(
                        UUID.fromString("2fac0e52-d9b1-4240-b29f-7ffbc4c2fa13"))
                .orElseThrow(() -> new RuntimeException("User Not Found")));
        Optional<AssignmentEntity> assignment = Optional.ofNullable(assignmentRepository.findById((long) 1)
                .orElseThrow(() -> new RuntimeException("Assignment Not Found")));
        var submition = SubmitionEntity.builder()
                .linkGithub(linkGithub)
                .review(resultReview)
                .user(userEntity.get())
                .isDeleted(false)
                .assignment(assignment.get())
                .build();
        if(resultReview.contains("Pass")) {
            submition.setStatus(SubmitStatus.PASS);
        }
        else if(resultReview.contains("Fail")) {
            submition.setStatus(SubmitStatus.FIX_REVIEW);
        }
        else {
            submition.setStatus(SubmitStatus.PENDING);
        }
        submitionRepository.save(submition);
    }

    @Override
    public PageResponse<?> getAllReviews(int page, int pageSize, UUID userId, long assignmentId) {
        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
        Page<SubmitionEntity> reviews = submitionRepository
                .findAllByAssignmentIdAndUserId(pageable, assignmentId, userId);
        List<ReviewResponseDTO> list = reviews.map(reviewMapper::toReviewResponseDTO)
                .stream().collect(Collectors.toList());
        return PageResponse.builder()
                .page(page)
                .pageSize(pageSize)
                .totalPage(reviews.getTotalPages())
                .items(list)
                .build();
    }

    @Override
    public ReviewResponseDTO getReviewById(long assignment, UUID id) {
        return reviewMapper.toReviewResponseDTO(
                submitionRepository.findTopByAssignmentIdAndUserIdOrderByIdDesc(assignment, id));
    }
}
