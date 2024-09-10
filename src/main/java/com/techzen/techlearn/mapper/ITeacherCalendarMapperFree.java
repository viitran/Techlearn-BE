package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.TeacherCalendarFreeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.sql.Time;
@Mapper(componentModel = "spring")
public interface ITeacherCalendarMapperFree {

    @Named("toTeacherCalendarFreeResponseDTO")
    default TeacherCalendarFreeResponseDTO toTeacherCalendarFreeResponseDTO(Object[] tuple) {
        TeacherCalendarFreeResponseDTO dto = new TeacherCalendarFreeResponseDTO();
        dto.setName((String) tuple[0]);
        dto.setTimeStart((Time) tuple[1]);
        dto.setTimeEnd((Time) tuple[2]);
        dto.setDateAppointment(((java.sql.Date) tuple[3]).toLocalDate());
        return dto;
    }
}

