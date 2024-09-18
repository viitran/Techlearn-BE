package com.techzen.techlearn.dto.response;

import com.techzen.techlearn.entity.ChapterEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentResponseDTO implements Serializable {
    Long id;
    String name;
    String description;
    ChapterEntity chapter;
    Boolean isDeleted;
}
