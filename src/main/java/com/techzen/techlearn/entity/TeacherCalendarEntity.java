package com.techzen.techlearn.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_calendar")
public class TeacherCalendarEntity {

    @EmbeddedId
    private TeacherCalendarId id;

    @ManyToOne
    @MapsId("idTeacher")
    @JoinColumn(name = "id_teacher")
    private TeacherEntity teacher;

    @ManyToOne
    @MapsId("idTime")
    @JoinColumn(name = "id_time")
    private CalendarEntity calendar;

    @JoinColumn(name = "date_appointment")
    private LocalDate dateAppointment;

    @JoinColumn(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @JoinColumn(name = "note")
    private String note;
}
