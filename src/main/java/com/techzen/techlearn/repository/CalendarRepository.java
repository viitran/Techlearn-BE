package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Integer> {
}
