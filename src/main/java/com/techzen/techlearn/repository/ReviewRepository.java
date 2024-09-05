package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query("select u from UserEntity u where u.id =:id")
    Optional<ReviewEntity> findReviewById(Long id);
}