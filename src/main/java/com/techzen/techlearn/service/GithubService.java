package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.GithubResquestDTO;
import org.springframework.stereotype.Service;

@Service
public interface GithubService {
    String reviewResponse(GithubResquestDTO resquestDTO) throws Exception;
}
