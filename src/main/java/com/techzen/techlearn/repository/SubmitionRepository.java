package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.SubmitionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubmitionRepository extends JpaRepository<SubmitionEntity, Long> {

    Page<SubmitionEntity> findAllByAssignmentIdAndUserId(Pageable pageable, Long assignmentId, UUID userId);

    SubmitionEntity findTopByAssignmentIdAndUserIdOrderByIdDesc(Long assignmentId, UUID userId);
}
