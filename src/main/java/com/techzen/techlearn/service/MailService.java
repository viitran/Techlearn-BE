package com.techzen.techlearn.service;

import com.techzen.techlearn.dto.CalendarDTO;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface MailService {
    void sendScheduleSuccessEmail(CalendarDTO calenderDto) throws MessagingException, IOException;
}
