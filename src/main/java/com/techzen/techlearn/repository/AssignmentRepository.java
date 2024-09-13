package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.AssignmentEntity;
import com.techzen.techlearn.enums.SubmitStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
    @Query("""
            SELECT a FROM AssignmentEntity a
            WHERE 1=1
            AND a.chapter.course.id = :courseId
            AND :userId IN (SELECT u.id FROM a.chapter.course.userEntities u)
            AND LOWER(a.name) LIKE CONCAT('%', :search, '%')
            """)
    Page<AssignmentEntity> findBySearchName(Pageable pageable, Long courseId, UUID userId, String search);

    @Query("""
            SELECT a FROM AssignmentEntity a
            JOIN a.chapter.course.userEntities u
            WHERE a.chapter.course.id = :courseId
            AND u.id = :userId
            """)
    Page<AssignmentEntity> findAssignmentsByCourseAndUser(Pageable pageable,
                                                          @Param("courseId") Long courseId,
                                                          @Param("userId") UUID userId);

    @Query("""
            SELECT a FROM AssignmentEntity a
            JOIN a.chapter.course.userEntities u
            WHERE a.chapter.course.id = :courseId
            AND u.id = :userId
            AND a.status =:filter
            """)
    Page<AssignmentEntity> findAssignmentsByStatus(Pageable pageable,
                                                 @Param("courseId") Long courseId,
                                                 @Param("userId") UUID userId,
                                                 @Param("filter") SubmitStatus filter);
}
