package com.techzen.techlearn.dto.response;

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
public class ReviewConfigResponseDTO implements Serializable {
    Long id;
    String promptStructure;
    Boolean isActive;
}
