package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.StudentCalendarRequestDTO;
import com.techzen.techlearn.dto.response.StudentCalendarResponseDTO;

public interface StudentCalendarService {
    StudentCalendarResponseDTO addStudentCalendar(StudentCalendarRequestDTO request);

    void deleteStudentById(Integer id);
}
