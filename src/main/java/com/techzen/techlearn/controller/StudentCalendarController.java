package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.request.StudentCalendarRequestDTO;
import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.StudentCalendarService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/student-calendar")
public class StudentCalendarController {

    StudentCalendarService studentCalendarService;

    @PostMapping
    public ResponseData<?> addStudentCalendar(@RequestBody @Valid StudentCalendarRequestDTO request) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
                .result(studentCalendarService.addStudentCalendar(request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<?> deleteStudentCalendar(@PathVariable Integer id){
        studentCalendarService.deleteStudentById(id);
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result("StudentCalendar with ID " + id + " was successfully deleted.")
                .build();
    }
}
