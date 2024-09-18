package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.response.AssignmentResponseDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.enums.SubmitStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AssignmentService {
    PageResponse<?> getAllAssignments(int page, int pageSize, Long courseId, UUID user, String search, SubmitStatus status);

    AssignmentResponseDTO getAssignmentById(Long id);
}
