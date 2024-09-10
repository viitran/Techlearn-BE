package com.techzen.techlearn.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherCalendarFreeResponseDTO {
    String name;
    Time timeStart;
    Time timeEnd;
    LocalDate dateAppointment;

    public TeacherCalendarFreeResponseDTO() {
    }

    public TeacherCalendarFreeResponseDTO(String name, Time timeStart, Time timeEnd, LocalDate dateAppointment) {
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.dateAppointment = dateAppointment;
    }
}
