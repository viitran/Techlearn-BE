package com.techzen.techlearn.mapper;

import com.techzen.techlearn.dto.response.GithubResponseDTO;
import org.mapstruct.Mapper;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface GithubMapper {

    GithubResponseDTO toGithubDTO(Map<String, Object> map);

    default String map(Object value) {
        return value != null ? value.toString() : null;
    }

}



