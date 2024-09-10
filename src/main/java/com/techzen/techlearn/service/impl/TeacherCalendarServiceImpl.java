package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import com.techzen.techlearn.dto.response.TechnicalTeacherResponseDTO;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.TeacherCalendarMappingContext;
import com.techzen.techlearn.mapper.TeacherCalendarMapper;
import com.techzen.techlearn.mapper.TechnicalTeacherMapper;
import com.techzen.techlearn.repository.TeacherCalendarRepository;
import com.techzen.techlearn.repository.TeacherRepository;
import com.techzen.techlearn.service.TeacherCalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
    TechnicalTeacherMapper technicalTeacherMapper;

    @Override
    public TeacherCalendarResponseDTO addTeacherCalendar(TeacherCalendarRequestDTO request) {
        UUID teacherId = UUID.fromString(request.getIdTeacher());
        LocalDate dateAppointment = LocalDate.parse(request.getDateAppointment());
        LocalTime timeStart = LocalTime.parse(request.getTimeStart());
        LocalTime timeEnd = LocalTime.parse(request.getTimeEnd());

        // Kiểm tra sự tồn tại của giáo viên
        TeacherEntity teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new AppException(ErrorCode.TEACHER_NOT_EXISTED));

        // Kiểm tra sự tồn tại của cuộc hẹn
        boolean isAppointmentExists = teacherCalendarRepository.existsByTeacherAndDateAppointment(teacher, dateAppointment);
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Date Appointment: " + dateAppointment);
        System.out.println("Appointment Exists: " + isAppointmentExists);

        if (isAppointmentExists) {
            throw new AppException(ErrorCode.TEACHER_CALENDAR_DATE_APPOINTMENT_EXISTED);
        }

        // Kiểm tra tính hợp lệ của ngày cuộc hẹn
        if (dateAppointment.isBefore(LocalDate.now())) {
            throw new AppException(ErrorCode.DATE_APPOINTMENT_NOT_SUITABLE);
        }

        // Kiểm tra tính hợp lệ của thời gian bắt đầu và thời gian kết thúc
        if (timeStart.isBefore(LocalTime.now())) {
            throw new AppException(ErrorCode.TIME_START_SUITABLE);
        } else if (timeStart.until(timeEnd, ChronoUnit.MINUTES) != 10) {
            throw new AppException(ErrorCode.TIME_NOT_SUITABLE);
        }

        TeacherCalendarEntity entity = teacherCalendarMapper.toTeacherCalendarEntity(request, teacherCalendarMappingContext);
        entity.setTeacher(teacher);
        entity.setDateAppointment(dateAppointment);
        TeacherCalendarEntity savedEntity = teacherCalendarRepository.save(entity);

        return teacherCalendarMapper.toTeacherCalendarResponseDTO(savedEntity);
    }




    @Override
    public List<TechnicalTeacherResponseDTO> findAppointments(String technicalName, String teacherName) {
        List<TeacherCalendarEntity> teacherCalendars = teacherCalendarRepository.findAppointmentsByTechnicalAndTeacher(technicalName, teacherName);
        if (teacherCalendars.isEmpty())
            throw new AppException(ErrorCode.NAME_TEACHER_OR_TECHNICAL_AND_CURRENT_DATE_NOT_EXISTED);
        return teacherCalendars.stream()
                .map(technicalTeacherMapper.INSTANCE::toTechnicalTeacherResponseDTO)
                .collect(Collectors.toList());
    }
}
