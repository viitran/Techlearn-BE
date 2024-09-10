package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.GitHubLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitHubLinkRepository extends JpaRepository<GitHubLinkEntity, Long> {
    Optional<GitHubLinkEntity> findGitHubLinkById(Long id);
}
