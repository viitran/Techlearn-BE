package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.GitHubLinkRequestDTO;
import com.techzen.techlearn.dto.response.GitHubLinkResponseDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import com.techzen.techlearn.entity.GitHubLinkEntity;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.mapper.GitHubLinkMapper;
import com.techzen.techlearn.repository.GitHubLinkRepository;
import com.techzen.techlearn.service.GitHubLinkService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GitHubLinkServiceImpl implements GitHubLinkService {

    GitHubLinkRepository githublinkRepository;
    GitHubLinkMapper githublinkMapper;

    @Override
    public GitHubLinkResponseDTO getGitHubLinkById(Long id) {
        GitHubLinkEntity githublink = githublinkRepository.findGitHubLinkById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return githublinkMapper.toGitHubLinkResponseDTO(githublink);
    }

    @Override
    public GitHubLinkResponseDTO addGitHubLink(GitHubLinkRequestDTO request) {
        GitHubLinkEntity githublink = githublinkMapper.toGitHubLinkEntity(request);
        githublink.setIsDeleted(false);
        githublink = githublinkRepository.save(githublink);
        return githublinkMapper.toGitHubLinkResponseDTO(githublink);
    }

    @Override
    public GitHubLinkResponseDTO updateGitHubLink(Long id, GitHubLinkRequestDTO request) {
        githublinkRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        var githublinkMap = githublinkMapper.toGitHubLinkEntity(request);
        githublinkMap.setId(id);
        githublinkMap.setIsDeleted(false);
        return githublinkMapper.toGitHubLinkResponseDTO(githublinkRepository.save(githublinkMap));
    }

    @Override
    public void deleteGitHubLink(Long id) {
        var githublink = githublinkRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        githublink.setIsDeleted(true);
        githublinkRepository.save(githublink);
    }

    @Override
    public PageResponse<?> getAllGitHubLink(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
        Page<GitHubLinkEntity> githublinks = githublinkRepository.findAll(pageable);
        List<GitHubLinkResponseDTO> list = githublinks.map(githublinkMapper::toGitHubLinkResponseDTO).stream().collect(Collectors.toList());
        return PageResponse.builder()
                .page(page)
                .pageSize(pageSize)
                .totalPage(githublinks.getTotalPages())
                .items(list)
                .build();
    }
}
