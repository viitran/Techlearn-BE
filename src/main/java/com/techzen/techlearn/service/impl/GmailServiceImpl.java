package com.techzen.techlearn.service.impl;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VAlarm;
import biweekly.component.VEvent;
import biweekly.parameter.Related;
import biweekly.property.Method;
import biweekly.property.Trigger;
import biweekly.util.Duration;
import com.techzen.techlearn.dto.CalendarDTO;
import com.techzen.techlearn.service.MailService;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.Address;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GmailServiceImpl implements MailService {

    JavaMailSender javaMailSender;
    @Override
    public void sendScheduleSuccessEmail(CalendarDTO calenderDto) throws MessagingException, IOException {
        // Send email
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setRecipients(Message.RecipientType.TO, getToAddress(calenderDto.getAttendees()));
        mimeMessage.setSubject(calenderDto.getSubject());

        MimeMultipart mimeMultipart = new MimeMultipart("mixed");

        mimeMultipart.addBodyPart(createCalenderMimeBody(calenderDto));

        mimeMessage.setContent(mimeMultipart);
        javaMailSender.send(mimeMessage);
    }

    private Address[] getToAddress(List<String> attendees) {
        return attendees.stream().map(email -> {
            Address address = null;
            try {
                address = new InternetAddress(email);
            } catch (AddressException e) {
                e.printStackTrace();
            }
            return address;
        }).toArray(Address[]::new);
    }

    private Date getStartDate(LocalDateTime eventDateTime) {
        Instant instant = eventDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    private String createCalendar(CalendarDTO calendarDto) {
        ICalendar icalendar = new ICalendar();
        icalendar.addProperty(new Method(Method.REQUEST));
        icalendar.setUrl(calendarDto.getMeetingLink());

        VEvent event = new VEvent();
        event.setUrl(calendarDto.getMeetingLink());
        event.setSummary(calendarDto.getSummary());
        event.setDescription(calendarDto.getMeetingLink());
        event.setDateStart(getStartDate(calendarDto.getEventDateTime()));
        event.setDuration(new Duration.Builder()
                .minutes(10)
                .build());
        event.setOrganizer(calendarDto.getOrganizer());

        Trigger trigger = new Trigger(getStartDate(calendarDto.getEventDateTime().minusMinutes(5)));
        VAlarm alarm = VAlarm.email(trigger, "Reminder for your meeting", "", calendarDto.getAttendees());
        alarm.setDescription("This is reminder for your meeting: " + calendarDto.getSummary());
        event.addAlarm(alarm);

        icalendar.addEvent(event);
        return Biweekly.write(icalendar).go();
    }

    private BodyPart createCalenderMimeBody(CalendarDTO calenderDto) throws IOException, MessagingException {
        MimeBodyPart calenderBody = new MimeBodyPart();

        final DataSource source = new ByteArrayDataSource(createCalendar(calenderDto), "text/calender; charset=UTF-8");
        calenderBody.setDataHandler(new DataHandler(source));
        calenderBody.setHeader("Content-Type", "text/calendar; charset=UTF-8; method=REQUEST");

        return calenderBody;
    }
}
