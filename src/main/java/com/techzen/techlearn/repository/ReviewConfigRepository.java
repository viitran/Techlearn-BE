package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.ReviewConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewConfigRepository extends JpaRepository<ReviewConfigEntity, Long> {
    @Query("select r from ReviewConfigEntity r where r.isActive=true")
    ReviewConfigEntity findByActive();

    @Query("select r from ReviewConfigEntity r where 1=1 and r.isActive=true and r.id=:id")
    ReviewConfigEntity findByIdActive(Long id);
}
