package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.request.ReviewConfigRequestDTO;
import com.techzen.techlearn.dto.response.ReviewConfigResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReviewConfigService {

    ReviewConfigResponseDTO saveConfig(ReviewConfigRequestDTO config);

    ReviewConfigResponseDTO getLatestConfig();

    ReviewConfigResponseDTO updateConfig(Long id, ReviewConfigRequestDTO config);
}
