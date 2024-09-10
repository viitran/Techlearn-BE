package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.ReviewRequestDTO;
import com.techzen.techlearn.dto.response.ReviewResponseDTO;
import com.techzen.techlearn.entity.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewEntity toReviewEntity(ReviewRequestDTO reviewRequestDTO);

    ReviewResponseDTO toReviewResponseDTO(ReviewEntity reviewEntity);
}
