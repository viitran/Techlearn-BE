package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface TeacherCalendarService {
    TeacherCalendarResponseDTO addTeacherCalendar(TeacherCalendarRequestDTO request);
}
