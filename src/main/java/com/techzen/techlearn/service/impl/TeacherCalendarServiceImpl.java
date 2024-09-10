package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.dto.response.TeacherCalendarFreeResponseDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import com.techzen.techlearn.dto.response.UserResponseDTO;
import com.techzen.techlearn.entity.CalendarEntity;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import com.techzen.techlearn.entity.UserEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.ITeacherCalendarMapperFree;
import com.techzen.techlearn.mapper.TeacherCalendarMappingContext;
import com.techzen.techlearn.mapper.TeacherCalendarMapper;
import com.techzen.techlearn.repository.CalendarRepository;
import com.techzen.techlearn.repository.TeacherCalendarRepository;
import com.techzen.techlearn.repository.TeacherRepository;
import com.techzen.techlearn.service.TeacherCalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherCalendarServiceImpl implements TeacherCalendarService {
    TeacherCalendarRepository teacherCalendarRepository;
    TeacherCalendarMapper teacherCalendarMapper;
    TeacherCalendarMappingContext teacherCalendarMappingContext;
    TeacherRepository teacherRepository;
    CalendarRepository calendarRepository;
    ITeacherCalendarMapperFree iTeacherCalendarMapperFree;

    @Override
    public TeacherCalendarResponseDTO addTeacherCalendar(TeacherCalendarRequestDTO request) {
        UUID teacherId = UUID.fromString(request.getIdTeacher());
        Integer calendarId = Integer.parseInt(request.getIdTime());
        LocalDate dateAppointment = LocalDate.parse(request.getDateAppointment());

        TeacherEntity teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new AppException(ErrorCode.TEACHER_NOT_EXISTED));
        CalendarEntity calendar = calendarRepository.findById(calendarId)
                .orElseThrow(() -> new AppException(ErrorCode.CALENDAR_NOT_EXISTED));

        if (teacherCalendarRepository.existsByTeacherAndCalendarAndDateAppointment(teacher, calendar, dateAppointment)) {
            throw new AppException(ErrorCode.TEACHER_CALENDAR_DATE_APPOINTMENT_EXISTED);
        }
        TeacherCalendarEntity entity = teacherCalendarMapper.toTeacherCalendarEntity(request, teacherCalendarMappingContext);
        entity.setTeacher(teacher);
        entity.setCalendar(calendar);
        entity.setDateAppointment(dateAppointment);
        TeacherCalendarEntity savedEntity = teacherCalendarRepository.save(entity);
        return teacherCalendarMapper.toTeacherCalendarResponseDTO(savedEntity);
    }

//    @Override
//    public PageResponse<?> getAllTeacherCalendar(int page, int pageSize) {
//        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
//        Page<Object[]> resultPage = teacherCalendarRepository.findAllTeacherFree(pageable);
//        System.out.println(resultPage);
//        List<TeacherCalendarFreeResponseDTO> list = resultPage.getContent().stream()
//                .map(iTeacherCalendarMapperFree::toTeacherCalendarFreeResponseDTO)
//                .collect(Collectors.toList());
//        return PageResponse.builder()
//                .page(page)
//                .pageSize(pageSize)
//                .totalPage(resultPage.getTotalPages())
//                .items(list)
//                .build();
//    }
    @Override
    public List<TeacherCalendarFreeResponseDTO> getAllTeacherCalendar() {
        List<Object[]> resultList = teacherCalendarRepository.findAllTeacherFree();
        System.out.println(resultList);
        return resultList.stream()
                .map(iTeacherCalendarMapperFree::toTeacherCalendarFreeResponseDTO)
                .collect(Collectors.toList());
    }

}
