package com.techzen.techlearn.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherCalendarResponseDTO implements Serializable {

    @JsonProperty("OwnerIds")
    List<String> ownerIds;

    @JsonProperty("StartTime")
    String startTime;

    @JsonProperty("EndTime")
    String endTime;
    String status;

    @JsonProperty("Subject")
    String subject;

    @JsonProperty("IsAllDay")
    String isAllDay;
}
