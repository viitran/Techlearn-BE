package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<TeacherEntity, UUID> {
}
