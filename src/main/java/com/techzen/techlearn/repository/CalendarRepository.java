package com.techzen.techlearn.repository;

import com.techzen.techlearn.dto.response.TechnicalTeacherResponseDTO;
import com.techzen.techlearn.entity.CalendarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Integer> {
}
