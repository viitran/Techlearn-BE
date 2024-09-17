package com.techzen.techlearn.dto;

import biweekly.property.Attendee;
import biweekly.property.Organizer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class CalendarDTO {
    private String subject;
    private String description;
    private String summary;
    private Organizer organizer;
    private String meetingLink;
    private LocalDateTime eventDateTime;
    private List<String> attendees;
}
