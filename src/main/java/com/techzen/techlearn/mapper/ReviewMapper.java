package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.ReviewResponseDTO;
import com.techzen.techlearn.entity.SubmitionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponseDTO toReviewResponseDTO(SubmitionEntity submition);
}
