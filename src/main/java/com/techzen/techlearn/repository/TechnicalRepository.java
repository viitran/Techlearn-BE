package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.TechnicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalRepository extends JpaRepository<TechnicalEntity,Integer> {
}
