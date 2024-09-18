package com.techzen.techlearn.mapper;

import com.techzen.techlearn.entity.Teacher;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.exception.AppException;
import com.techzen.techlearn.repository.TeacherRepository;
import com.techzen.techlearn.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherMapperHelper {

    TeacherRepository teacherRepository;

    @Named("mapOwnerIdToTeacher")
    public Teacher mapOwnerIdToTeacher(String ownerId) {
        return teacherRepository.findById(UUID.fromString(ownerId))
                .orElseThrow(() -> new AppException(ErrorCode.TEACHER_NOT_EXISTED));
    }
}

