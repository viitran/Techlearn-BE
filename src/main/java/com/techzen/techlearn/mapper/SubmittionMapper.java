package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.SubmittionResponseDTO;
import com.techzen.techlearn.entity.SubmitionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubmittionMapper {

    SubmittionResponseDTO toSubmittionResponseDTO(SubmitionEntity submitionEntity);
}
