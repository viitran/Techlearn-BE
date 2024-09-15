package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.enums.SubmitStatus;
import com.techzen.techlearn.service.AssignmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/assignments")
public class AssignmentController {

    AssignmentService assignmentService;

    @GetMapping
    public ResponseData<?> getAllAssignment(@RequestParam(defaultValue = "1", required = false) int page,
                                            @RequestParam(defaultValue = "10", required = false) int pageSize,
                                            @RequestParam long courseId,
                                            @RequestParam UUID userId,
                                            @RequestParam(required = false) String search,
                                            @RequestParam(required = false) SubmitStatus status) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(assignmentService.getAllAssignments(page, pageSize, courseId, userId, search, status))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> getAssignmentById(@PathVariable long id) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(assignmentService.getAssignmentById(id))
                .build();
    }
}
