package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.Teacher;
import com.techzen.techlearn.entity.TeacherCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TeacherCalendar2Repository extends JpaRepository<TeacherCalendar, Integer> {

    boolean existsByTeacherAndStartTimeAndEndTime(Teacher teacher, LocalDateTime startTime, LocalDateTime endTime);
    List<TeacherCalendar> findByTeacher(Teacher teacher);
}
