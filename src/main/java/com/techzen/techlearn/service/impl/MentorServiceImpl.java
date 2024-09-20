package com.techzen.techlearn.service.impl;

import com.techzen.techlearn.dto.request.MentorRequestDTO;
import com.techzen.techlearn.dto.response.MentorResponseDTO;
import com.techzen.techlearn.entity.Mentor;
import com.techzen.techlearn.mapper.MentorMapper;
import com.techzen.techlearn.repository.MentorRepository;
import com.techzen.techlearn.service.MentorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MentorServiceImpl implements MentorService {

    MentorRepository mentorRepository;
    MentorMapper mentorMapper;

    @Override
    public MentorResponseDTO createMentor(MentorRequestDTO dto) {
        Mentor mentor = mentorMapper.toEntity(dto);

        if(mentor.getId() == null) {
            mentor.setId(UUID.randomUUID());
        }

        return mentorMapper.toTeacherResponseDTO(mentorRepository.save(mentor));
    }

    @Override
    public List<MentorResponseDTO> findAllMentor() {
        return mentorRepository.findAll().stream().map(mentorMapper::toTeacherResponseDTO)
                .collect(Collectors.toList());
    }
}
