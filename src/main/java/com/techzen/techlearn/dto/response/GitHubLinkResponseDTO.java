package com.techzen.techlearn.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GitHubLinkResponseDTO implements Serializable {
    Long id;
    String url;
    String createdBy;
    LocalDateTime createdDate;
    String modifiedBy;
    LocalDateTime modifiedDate;
}
