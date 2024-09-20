package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.Mentor;
import com.techzen.techlearn.entity.Teacher;
import com.techzen.techlearn.entity.TeacherCalendar;
import com.techzen.techlearn.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeacherCalendarRepository extends JpaRepository<TeacherCalendar, Integer> {

    boolean existsByTeacherAndStartTimeAndEndTime(Teacher teacher, LocalDateTime startTime, LocalDateTime endTime);
    @Query("select tc from TeacherCalendar tc where tc.startTime >= current_time and tc.teacher.id = :id")
    List<TeacherCalendar> findByTeacherId(UUID id);

    List<TeacherCalendar> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndTeacher(LocalDateTime startTime, LocalDateTime endTime, Teacher teacher);

    List<TeacherCalendar> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndMentor(LocalDateTime startTime, LocalDateTime endTime, Mentor mentor);
    List<TeacherCalendar> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndUser(LocalDateTime startTime, LocalDateTime endTime, UserEntity user);

    Optional<TeacherCalendar> findByIdAndTeacher(Integer id, Teacher teacher);

    Optional<TeacherCalendar> findByIdAndMentor(Integer id, Mentor mentor);
//    @Query("SELECT tc FROM TeacherCalendar tc "
//            + "JOIN tc.teacher t "
//            + "JOIN TechnicalTeacher tt ON t.id = tt.teacher.id "
//            + "JOIN TeacherChapter tch ON tt.id = tch.technicalTeacher.id "
//            + "WHERE (:teacherName IS NULL OR t.name LIKE %:teacherName%)  AND tc.status = 'FREE'"
//            + "AND (:technicalTeacherName IS NULL OR tt.name LIKE %:technicalTeacherName%) "
//            + "AND (:chapterName IS NULL OR tch.name LIKE %:chapterName%)")
//    List<TeacherCalendar> findByFilters(
//            @Param("teacherName") String teacherName,
//            @Param("technicalTeacherName") String technicalTeacherName,
//            @Param("chapterName") String chapterName
//    );

}
