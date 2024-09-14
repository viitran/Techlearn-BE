package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.StudentCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCalendarRepository extends JpaRepository<StudentCalendar, Integer> {

}
