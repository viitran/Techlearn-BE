package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO2;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO2;
import com.techzen.techlearn.entity.StudentCalendar;
import com.techzen.techlearn.entity.TeacherCalendar;
import com.techzen.techlearn.entity.UserEntity;
import com.techzen.techlearn.enums.CalendarStatus;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.TeacherCalendarMapper;
import com.techzen.techlearn.repository.StudentCalendarRepository;
import com.techzen.techlearn.repository.TeacherCalendarRepository;
import com.techzen.techlearn.repository.UserRepository;
import com.techzen.techlearn.service.StudentCalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentCalendarServiceImpl implements StudentCalendarService {

    UserRepository userRepository;
    StudentCalendarRepository studentCalendarRepository;
    TeacherCalendarRepository teacherCalendarRepository;
    TeacherCalendarMapper teacherCalendarMapper;

    @Override
    public TeacherCalendarResponseDTO2 addStudentCalendar(TeacherCalendarRequestDTO2 request) {

        TeacherCalendar calendar = teacherCalendarRepository.findById(Integer.parseInt(request.getId())).orElseThrow(
                () -> new AppException(ErrorCode.CALENDAR_NOT_EXISTED)
        );

        UserEntity user = userRepository.findUserById(UUID.fromString(request.getUserId())).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)
        );

        calendar.setStatus(CalendarStatus.BOOKED);
        calendar.setCourseId(Long.parseLong(request.getCourseId()));
        calendar.setChapterId(Long.parseLong(request.getChapterId()));
        calendar.setUser(user);

        return teacherCalendarMapper.toDTO(teacherCalendarRepository.save(calendar));
    }

    @Override
    public void deleteStudentById(Integer id) {
        StudentCalendar studentCalendar = studentCalendarRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CALENDAR_NOT_EXISTED));
        studentCalendarRepository.delete(studentCalendar);
    }


}
