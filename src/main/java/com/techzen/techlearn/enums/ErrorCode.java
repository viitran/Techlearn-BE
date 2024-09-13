package com.techzen.techlearn.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    GET_SUCCESSFUL(1010, "Get successful", HttpStatus.OK),
    ADD_SUCCESSFUL(1011, "Add successful", HttpStatus.OK),
    DELETE_SUCCESSFUL(1012, "Delete successful", HttpStatus.OK),
    UPDATE_SUCCESSFUL(1013, "Update successful", HttpStatus.OK),
    INVALID_DATA(1014, "Invalid data", HttpStatus.BAD_REQUEST),
    REVIEW_NOT_FOUND(1020, "Review not found", HttpStatus.BAD_REQUEST),

    // user code user : 110*
    USER_EXISTED(1101, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1102, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1103, "User not found", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1104, "User not existed", HttpStatus.NOT_FOUND),
    FULL_NAME_INVALID(1105, "Full name must be not blank", HttpStatus.BAD_REQUEST),
    AGE_INVALID(1106, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1107, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),


    // prompt code prompt : 120*
    PROMPT_STRUCTURE(1201, "Prompt structure must be not blank", HttpStatus.BAD_REQUEST),
    PROMPT_STRUCTURE_NOT_FOUND(1202, "Prompt structure not found", HttpStatus.BAD_REQUEST),


    // error code github : 130*
    GITHUB_LINK(1301, "Github link must be not blank", HttpStatus.BAD_REQUEST),
    GITHUB_NOT_FOUND(1302, "GitHub link not found or invalid! ", HttpStatus.BAD_REQUEST),
    GITHUB_API_ERROR(1303, "Error calling GitHub API", HttpStatus.INTERNAL_SERVER_ERROR),

    // error code Courser : 140*
    COURSE_NOT_FOUND(1401, "Course not found", HttpStatus.BAD_REQUEST),

    ;

    Integer code;
    String message;
    HttpStatusCode statusCode;
}
