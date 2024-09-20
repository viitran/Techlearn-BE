package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.request.StudentCalendarRequestDTO;
import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO2;
import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO2;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.StudentCalendarService;
import com.techzen.techlearn.service.TeacherCalendar2Service;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/student-calendar")
public class StudentCalendarController {

    StudentCalendarService studentCalendarService;
    TeacherCalendar2Service teacherCalendarService;

    @GetMapping("/")
    public List<TeacherCalendarResponseDTO2> getSchedule(@RequestParam("StartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                         @RequestParam("EndDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        return teacherCalendarService.findByDateRange(startDate, endDate);
    }

    @PutMapping("/{id}")
    public ResponseData<?> addStudentCalendar(@RequestBody @Valid TeacherCalendarRequestDTO2 request) throws MessagingException, IOException {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
                .result(studentCalendarService.addStudentCalendar(request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<?> deleteStudentCalendar(@PathVariable UUID id){
        studentCalendarService.deleteStudentById(id);
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result("StudentCalendar with ID " + id + " was successfully deleted.")
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> findAllCalendarStudent(@PathVariable UUID id){
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(studentCalendarService.getStudentCalendarsByUserId(id))
                .build();
    }
}
