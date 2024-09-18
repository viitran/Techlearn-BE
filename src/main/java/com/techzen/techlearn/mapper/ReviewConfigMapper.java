package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.ReviewConfigRequestDTO;
import com.techzen.techlearn.dto.response.ReviewConfigResponseDTO;
import com.techzen.techlearn.entity.ReviewConfigEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewConfigMapper {

    ReviewConfigEntity toReviewConfigEntity(ReviewConfigRequestDTO requestDTO);

    ReviewConfigResponseDTO toReviewConfigResponseDTO(ReviewConfigEntity entity);
}
