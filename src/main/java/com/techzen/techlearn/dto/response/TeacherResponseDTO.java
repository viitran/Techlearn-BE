package com.techzen.techlearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDTO {
    private UUID id;
    private String name;
    private String avatar;
    private String color;
}
