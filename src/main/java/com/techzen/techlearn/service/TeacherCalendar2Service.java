package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO2;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO2;

import java.util.List;

public interface TeacherCalendar2Service {
    TeacherCalendarResponseDTO2 addTeacherCalendar(TeacherCalendarRequestDTO2 request);

    List<TeacherCalendarResponseDTO2> findAll();

    void deleteTeacherCalendar(Integer id);

    TeacherCalendarResponseDTO2 updateCalendarTeacher(Integer id, TeacherCalendarRequestDTO2 request);
}
