package com.techzen.techlearn.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GithubResponseDTO {
    String name;
//    String path;
//    String sha;
//    String size;
//    String url;
//    String html_url;
//    String git_url;
//    String download_url;
//    String type;
    String content;
    String encoding;
}
