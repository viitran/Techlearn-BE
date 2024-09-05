package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.mapper.TeacherCalendarMapper;
import com.techzen.techlearn.repository.TeacherCalendarRepository;
import com.techzen.techlearn.service.TeacherCalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherCalendarServiceImpl implements TeacherCalendarService {
    TeacherCalendarRepository teacherCalendarRepository;
    TeacherCalendarMapper teacherCalendarMapper;

    @Override
    public TeacherCalendarResponseDTO addTeacherCalendar(TeacherCalendarRequestDTO request) {
        TeacherCalendarEntity teacherCalendarEntity = teacherCalendarMapper.toTeacherCalendarEntity(request);
        TeacherCalendarEntity savedEntity = teacherCalendarRepository.save(teacherCalendarEntity);
        return teacherCalendarMapper.toTeacherCalendarResponseDTO(savedEntity);
    }
}
