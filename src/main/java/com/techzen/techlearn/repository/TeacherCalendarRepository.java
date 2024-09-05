package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.TeacherCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherCalendarRepository extends JpaRepository<TeacherCalendarEntity, UUID> {
}
