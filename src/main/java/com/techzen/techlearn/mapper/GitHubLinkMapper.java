package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.request.GitHubLinkRequestDTO;
import com.techzen.techlearn.dto.response.GitHubLinkResponseDTO;
import com.techzen.techlearn.entity.GitHubLinkEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GitHubLinkMapper {
    GitHubLinkEntity toGitHubLinkEntity(GitHubLinkRequestDTO githublinkRequestDTO);

    GitHubLinkResponseDTO toGitHubLinkResponseDTO(GitHubLinkEntity githublinkEntity);
}
