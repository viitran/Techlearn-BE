package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.CalendarEntity;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface TeacherCalendarRepository extends JpaRepository<TeacherCalendarEntity, UUID> {

    boolean existsByTeacherAndCalendarAndDateAppointment(TeacherEntity teacher, CalendarEntity calendar, LocalDate dateAppointment);
}
