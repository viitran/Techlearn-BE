package com.techzen.techlearn.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubResquestDTO {
    @NotBlank(message = "GITHUB_LINK")
    String github_link;
    String exerciseTitle;
    String idUser;
    String idAssignment;
}
