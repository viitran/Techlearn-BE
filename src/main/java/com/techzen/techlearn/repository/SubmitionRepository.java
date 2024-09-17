package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.SubmitionEntity;
import com.techzen.techlearn.enums.SubmitStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubmitionRepository extends JpaRepository<SubmitionEntity, Long> {

    Page<SubmitionEntity> findAllByAssignmentIdAndUserId(Pageable pageable, Long assignmentId, UUID userId);
    Page<SubmitionEntity> findAllByUserIdAndStatus(Pageable pageable, UUID userId, SubmitStatus status);
    SubmitionEntity findTopByAssignmentIdAndUserIdOrderByIdDesc(Long assignmentId, UUID userId);
}
