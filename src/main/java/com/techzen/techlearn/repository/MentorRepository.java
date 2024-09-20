package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MentorRepository extends JpaRepository<Mentor, UUID> {
}
