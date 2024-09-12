package com.techzen.techlearn.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCalendarResponseDTO {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("StartTime")
    private String startTime;

    @JsonProperty("EndTime")
    private String endTime;

    @JsonProperty("IdTeacher")
    private String idTeacher;
}
