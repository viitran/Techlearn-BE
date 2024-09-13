package com.techzen.techlearn.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewConfigRequestDTO {
    @NotBlank(message = "PROMPT_STRUCTURE")
    String promptStructure;
}
