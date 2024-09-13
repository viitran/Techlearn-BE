package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.CourseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    Page<CourseEntity> findAllByUserEntitiesId(UUID userId, Pageable pageable);

}
