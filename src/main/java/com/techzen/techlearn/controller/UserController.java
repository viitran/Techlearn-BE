package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.CalendarDTO;
import com.techzen.techlearn.dto.request.UserRequestDTO;
import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.MailService;
import com.techzen.techlearn.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    UserService userService;

    MailService mailService;

    @GetMapping
    public ResponseData<?> getAllUser(@RequestParam(required = false, defaultValue = "1") int page,
                                      @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(userService.getAllUser(page, pageSize))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> getUserById(@PathVariable UUID id) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(userService.getUserById(id))
                .build();
    }

    @PostMapping
    public ResponseData<?> addUser(@RequestBody @Valid UserRequestDTO request) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
                .result(userService.addUser(request))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateUser(@PathVariable UUID id, @RequestBody UserRequestDTO request) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.UPDATE_SUCCESSFUL.getCode())
                .message(ErrorCode.UPDATE_SUCCESSFUL.getMessage())
                .result(userService.updateUser(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<?> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.DELETE_SUCCESSFUL.getCode())
                .message(ErrorCode.DELETE_SUCCESSFUL.getMessage())
                .message("Delete user success")
                .build();
    }

    @GetMapping("/send-email")
    public void sendEmail() {
        try {
            CalendarDTO calendarDTO = CalendarDTO.builder()
                    .attendees(List.of("thanhtuanle0209@gmail.com"))  // Danh sách email người nhận
                    .subject("Test send calendar mail")
                    .description("Hello I'm Tuan dep trai nhat the gioi") // Mô tả của sự kiện
                    .summary("Summary of the meeting")
                    .meetingLink("https://example.com/meeting")
                    .eventDateTime(LocalDateTime.now().plusDays(1)) // (1 ngày sau)
                    .build();
            mailService.sendScheduleSuccessEmail(calendarDTO);
        } catch (MessagingException | IOException e) {
            log.error("Error while sending email: {}", e.getMessage());
        }
    }
}
