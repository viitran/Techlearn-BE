package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherCalendarService {
    TeacherCalendarResponseDTO addTeacherCalendar(TeacherCalendarRequestDTO request);
    //PageResponse<?> getAllTeacherCalendar(int page, int pageSize);
    List<?> getAllTeacherCalendar();

}
