package com.techzen.techlearn.dto.response;

import com.techzen.techlearn.entity.AssignmentEntity;
import com.techzen.techlearn.entity.UserEntity;
import com.techzen.techlearn.enums.SubmitStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmittionResponseDTO {

    private long id;
    private String linkGithub;
    private String review;
    private SubmitStatus status;
    private AssignmentEntity assignment;
}
