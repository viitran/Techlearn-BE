package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.response.AssignmentResponseDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.entity.AssignmentEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.enums.SubmitStatus;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.AssignmentMapper;
import com.techzen.techlearn.repository.AssignmentRepository;
import com.techzen.techlearn.service.AssignmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssigmentServiceImpl implements AssignmentService {
    AssignmentRepository assignmentRepository;
    AssignmentMapper assignmentMapper;

    @Override
    public PageResponse<?> getAllAssignments(int page, int pageSize, Long courseId, UUID user, String search, SubmitStatus status) {
        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
        Page<AssignmentEntity> assignment;
        if(search != null && !search.isEmpty()) {
            assignment = assignmentRepository.findBySearchName(pageable, courseId, user, search);
        }
        else if(status != null) {
            assignment = assignmentRepository.findAssignmentsByStatus(pageable, courseId, user, status);
        }
        else {
            assignment = assignmentRepository.findAssignmentsByCourseAndUser(pageable, courseId, user);
        }
        List<AssignmentResponseDTO> list = assignment.map(assignmentMapper::toAssignmentResponseDTO)
                .stream().collect(Collectors.toList());
        return PageResponse.builder()
                .page(page)
                .pageSize(pageSize)
                .totalPage(assignment.getTotalPages())
                .items(list)
                .build();
    }

    @Override
    public AssignmentResponseDTO getAssignmentById(Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.ASSIGNMENT_NOT_FOUND));
        return assignmentMapper.toAssignmentResponseDTO(assignment);
    }
}
