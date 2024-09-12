package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.SubmitionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    SubmitionService submitionService;

    @GetMapping
    public ResponseData<?> getAllReview(@RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int pageSize,
                                        @RequestParam UUID id, @RequestParam long assignment){
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(submitionService.getAllReviews(page, pageSize, id, assignment))
                .build();
    }

    @GetMapping("/{assignment}")
    public ResponseData<?> getReviewById(@RequestParam UUID id, @PathVariable long assignment) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(submitionService.getReviewById(assignment, id))
                .build();
    }

}
