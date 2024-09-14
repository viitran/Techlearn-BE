package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.CourseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/courses")
public class CourseController {

    CourseService courseService;

    @GetMapping()
    public ResponseData<?> getCourseByUser(@RequestParam(required = false, defaultValue = "1") int page,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam String id){

        UUID submissionID = UUID.fromString(id);
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(courseService.getCoursesByUserId(submissionID, page, pageSize))
                .build();

    }

}
