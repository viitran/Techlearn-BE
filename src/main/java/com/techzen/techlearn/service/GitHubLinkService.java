package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.GitHubLinkRequestDTO;
import com.techzen.techlearn.dto.response.GitHubLinkResponseDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import org.springframework.stereotype.Service;

@Service
public interface GitHubLinkService {
    GitHubLinkResponseDTO getGitHubLinkById(Long id);

    GitHubLinkResponseDTO addGitHubLink(GitHubLinkRequestDTO request);

    GitHubLinkResponseDTO updateGitHubLink(Long id, GitHubLinkRequestDTO request);

    void deleteGitHubLink(Long id);

    PageResponse<?> getAllGitHubLink(int page, int pageSize);
}
