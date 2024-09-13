package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO2;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO2;

public interface StudentCalendarService {
    TeacherCalendarResponseDTO2 addStudentCalendar(TeacherCalendarRequestDTO2 request);

    void deleteStudentById(Integer id);
}
