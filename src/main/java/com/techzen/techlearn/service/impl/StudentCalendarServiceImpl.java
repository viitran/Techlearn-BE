package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.StudentCalendarRequestDTO;
import com.techzen.techlearn.dto.response.StudentCalendarResponseDTO;
import com.techzen.techlearn.entity.StudentCalendar;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.StudentCalendarMapper;
import com.techzen.techlearn.repository.StudentCalendarRepository;
import com.techzen.techlearn.service.StudentCalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentCalendarServiceImpl implements StudentCalendarService {

    StudentCalendarMapper studentCalendarMapper;
    StudentCalendarRepository studentCalendarRepository;

    @Override
    public StudentCalendarResponseDTO addStudentCalendar(StudentCalendarRequestDTO request) {
        StudentCalendar studentCalendar = studentCalendarMapper.toStudentCalendar(request);
        return studentCalendarMapper.toStudentCalendarResponseDTO(studentCalendarRepository.save(studentCalendar));
    }

    @Override
    public void deleteStudentById(Integer id) {
        StudentCalendar studentCalendar = studentCalendarRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CALENDAR_NOT_EXISTED));
        studentCalendarRepository.delete(studentCalendar);
    }


}
