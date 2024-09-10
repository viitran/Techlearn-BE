package com.techzen.techlearn.repository;

import com.techzen.techlearn.dto.response.TeacherCalendarFreeResponseDTO;
import com.techzen.techlearn.entity.CalendarEntity;
import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TeacherCalendarRepository extends JpaRepository<TeacherCalendarEntity, UUID> {

    boolean existsByTeacherAndCalendarAndDateAppointment(TeacherEntity teacher, CalendarEntity calendar, LocalDate dateAppointment);

    @Query(nativeQuery = true, value = "select teacher.name, calendar.time_start, calendar.time_end, " +
            "teacher_calendar.date_appointment, teacher_calendar.is_all_day \n" +
            "from calendar join teacher_calendar on calendar.id = teacher_calendar.id_time \n" +
            "join teacher on teacher_calendar.id_teacher = teacher.id where teacher_calendar.status = 'Đang trống' \n" +
            "and teacher_calendar.date_appointment >= CURRENT_DATE or( teacher_calendar.date_appointment >= CURRENT_DATE" +
            " and calendar.time_end >= current_time)")
    List<Object[]> findAllTeacherFree();
   // Page<Object[]> findAllTeacherFree(Pageable pageable);

}
