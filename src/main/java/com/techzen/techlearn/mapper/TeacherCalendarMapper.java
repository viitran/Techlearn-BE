package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.TeacherCalendarRequestDTO2;
import com.techzen.techlearn.dto.response.TeacherCalendarResponseDTO2;
import com.techzen.techlearn.entity.TeacherCalendar;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {TeacherMapperHelper.class})
public interface TeacherCalendarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teacher", source = "ownerId", qualifiedByName = "mapOwnerIdToTeacher")
    @Mapping(target = "status", source = "status")
    TeacherCalendar toEntity(TeacherCalendarRequestDTO2 request);

    @Mapping(target = "ownerId", source = "teacher.id")
    @Mapping(target = "userId", source = "user.id")
    TeacherCalendarResponseDTO2 toDTO(TeacherCalendar teacherCalendar);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(TeacherCalendarRequestDTO2 request, @MappingTarget TeacherCalendar entity);
}


