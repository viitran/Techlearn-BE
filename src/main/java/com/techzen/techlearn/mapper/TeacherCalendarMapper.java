package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TeacherCalendarMapper {

    @Mappings({
            @Mapping(target = "teacher", source = "ownerIds", qualifiedByName = "mapToTeacherEntity"),
            @Mapping(target = "dateAppointment", expression = "java(parseDateTime(dto.getTimeStart()).toLocalDate())"),
            @Mapping(target = "timeStart", expression = "java(parseDateTime(dto.getTimeStart()).toLocalTime())"),
            @Mapping(target = "timeEnd", expression = "java(parseDateTime(dto.getTimeEnd()).toLocalTime())"),
            @Mapping(target = "isAllDay", source = "isAllDay"),
    })
    TeacherCalendarEntity toTeacherCalendarEntity(TeacherCalendarRequestDTO dto, @Context TeacherCalendarMappingContext context);

    @Mappings({
            @Mapping(target = "subject", source = "note"),
            @Mapping(target = "startTime", expression = "java(mapDateTime(entity.getDateAppointment(), entity.getTimeStart()))"),
            @Mapping(target = "endTime", expression = "java(mapDateTime(entity.getDateAppointment(), entity.getTimeEnd()))"),
            @Mapping(target = "isAllDay", source = "isAllDay"),
            @Mapping(target = "ownerIds", expression = "java(mapOwnerIds(entity.getTeacher().getId()))"),
    })
    TeacherCalendarResponseDTO toTeacherCalendarResponseDTO(TeacherCalendarEntity entity);

    @Named("mapDateTime")
    default String mapDateTime(java.time.LocalDate date, java.time.LocalTime time) {
        return date.atTime(time).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Named("mapToTeacherEntity")
    default TeacherEntity mapToTeacherEntity(List<String> ownerIds, @Context TeacherCalendarMappingContext context) {
        if (ownerIds == null || ownerIds.isEmpty()) {
            throw new RuntimeException("No owner IDs provided");
        }
        return context.getTeacherRepository().findById(UUID.fromString(ownerIds.get(0)))
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Named("mapOwnerIds")
    default java.util.List<String> mapOwnerIds(UUID id) {
        return Collections.singletonList(id.toString());
    }

    default LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME);
    }
}

