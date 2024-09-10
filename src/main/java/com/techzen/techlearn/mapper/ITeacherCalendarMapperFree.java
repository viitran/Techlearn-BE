package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.TeacherCalendarFreeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface ITeacherCalendarMapperFree {

    @Named("toTeacherCalendarFreeResponseDTO")
    default TeacherCalendarFreeResponseDTO toTeacherCalendarFreeResponseDTO(Object[] tuple) {
        TeacherCalendarFreeResponseDTO dto = new TeacherCalendarFreeResponseDTO();
        dto.setName((String) tuple[0]);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Time timeStart = (Time) tuple[1];
        dto.setTimeStart(timeFormat.format(timeStart));
        Time timeEnd = (Time) tuple[2];
        dto.setTimeEnd(timeFormat.format(timeEnd));
        Date dateAppointment = (Date) tuple[3];
        dto.setDateAppointment(dateFormat.format(dateAppointment));
        Boolean isAllDay = (Boolean) tuple[4];
        dto.setIsAllDay(isAllDay.toString());
        return dto;
    }

}

