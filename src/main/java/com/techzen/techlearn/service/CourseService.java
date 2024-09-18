package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.response.CourseResponseDTO;
import com.techzen.techlearn.dto.response.PageResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CourseService {
    public CourseResponseDTO findById(long idCourse);
    public PageResponse<?> getCoursesByUserId(UUID userId, int page, int pageSize);
}
