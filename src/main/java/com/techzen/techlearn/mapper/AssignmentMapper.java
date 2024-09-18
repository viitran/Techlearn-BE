package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.AssignmentResponseDTO;
import com.techzen.techlearn.entity.AssignmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    AssignmentResponseDTO toAssignmentResponseDTO(AssignmentEntity assignment);
}
