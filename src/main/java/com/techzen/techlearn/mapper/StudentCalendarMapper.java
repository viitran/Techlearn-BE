package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.StudentCalendarRequestDTO;
import com.techzen.techlearn.entity.StudentCalendar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCalendarMapper {
    StudentCalendar toStudentCalendar(StudentCalendarRequestDTO studentCalendarRequestDTO);

//    StudentCalendarResponseDTO toStudentCalendarResponseDTO(StudentCalendar studentCalendar);
}
