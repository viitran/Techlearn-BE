package com.techzen.techlearn.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequestDTO {
    @NotBlank(message = "content shouldn't empty")
    String content;
}