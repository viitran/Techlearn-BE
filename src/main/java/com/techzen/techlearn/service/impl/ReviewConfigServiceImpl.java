package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.ReviewConfigRequestDTO;
import com.techzen.techlearn.dto.response.ReviewConfigResponseDTO;
import com.techzen.techlearn.entity.ReviewConfigEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.ReviewConfigMapper;
import com.techzen.techlearn.repository.ReviewConfigRepository;
import com.techzen.techlearn.service.ReviewConfigService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewConfigServiceImpl implements ReviewConfigService {

    ReviewConfigRepository reviewConfigRepository;
    ReviewConfigMapper reviewConfigMapper;

    @Override
    public ReviewConfigResponseDTO saveConfig(ReviewConfigRequestDTO config) {
        ReviewConfigEntity reviewConfig = reviewConfigMapper.toReviewConfigEntity(config);
        reviewConfig.setIsDeleted(false);
        return reviewConfigMapper.toReviewConfigResponseDTO(reviewConfigRepository.save(reviewConfig));
    }

    @Override
    public ReviewConfigResponseDTO getLatestConfig() {
        return reviewConfigMapper.toReviewConfigResponseDTO(reviewConfigRepository.findTopByOrderByIdDesc());
    }

    @Override
    public ReviewConfigResponseDTO updateConfig(Long id, ReviewConfigRequestDTO config) {
        reviewConfigRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PROMPT_STRUCTURE_NOT_FOUND));
        var reviewConfig = reviewConfigMapper.toReviewConfigEntity(config);
        reviewConfig.setId(id);
        reviewConfig.setIsDeleted(false);
        return reviewConfigMapper.toReviewConfigResponseDTO(reviewConfigRepository.save(reviewConfig));
    }
}
