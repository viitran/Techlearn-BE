package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherCalendarMapper {

    @Mappings({
            @Mapping(target = "id.idTeacher", source = "idTeacher"),
            @Mapping(target = "id.idTime", source = "idTime"),
            @Mapping(target = "dateAppointment", source = "dateAppointment"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "note", source = "note"),
            @Mapping(target = "teacher.id", source = "idTeacher"),
            @Mapping(target = "calendar.id", source = "idTime")
    })
    TeacherCalendarEntity toTeacherCalendarEntity(TeacherCalendarRequestDTO dto);

    TeacherCalendarResponseDTO toTeacherCalendarResponseDTO(TeacherCalendarEntity entity);
}
