package com.techzen.techlearn.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StudentCalendarRequestDTO {

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
