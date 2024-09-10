package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.ReviewConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewConfigRepository extends JpaRepository<ReviewConfigEntity, Long> {
    ReviewConfigEntity findTopByOrderByIdDesc();
}
