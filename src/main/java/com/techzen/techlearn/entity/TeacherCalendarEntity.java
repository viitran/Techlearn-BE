package com.techzen.techlearn.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_all_day = false")
@Table(name = "teacher_calendar")
public class TeacherCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "id_time")
    private CalendarEntity calendar;

    @Column(name = "date_appointment")
    private LocalDate dateAppointment;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @Column(name = "note")
    private String note;

    @Column(name = "is_all_day")
    private Boolean isAllDay;
}
