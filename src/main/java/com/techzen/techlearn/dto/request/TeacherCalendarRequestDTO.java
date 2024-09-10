package com.techzen.techlearn.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherCalendarRequestDTO {
    @JsonProperty("IsAllDay")
    Boolean isAllDay;

    @JsonProperty("OwnerIds")
    List<Integer> ownerIds;

    @JsonProperty("StartTime")
    String timeStart;

    @JsonProperty("EndTime")
    String timeEnd;

    @JsonProperty("Subject")
    String note;

    @JsonProperty("EndTimezone")
    String endTimezone;

    Integer id;

    String recurrenceException;
    String recurrenceID;
    String recurrenceRule;

    @JsonProperty("StartTimezone")
    String startTimezone;
}
