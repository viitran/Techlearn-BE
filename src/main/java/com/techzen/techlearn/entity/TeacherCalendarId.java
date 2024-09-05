package com.techzen.techlearn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Embeddable
@Getter
@Setter
public class TeacherCalendarId implements Serializable {

    @Column(name = "id_teacher", columnDefinition = "BINARY(16)")
    private UUID idTeacher;

    @Column(name = "id_time", columnDefinition = "BINARY(16)")
    private UUID idTime;

    public TeacherCalendarId() {
    }

    public TeacherCalendarId(UUID idTeacher, UUID idTime) {
        this.idTeacher = idTeacher;
        this.idTime = idTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherCalendarId that = (TeacherCalendarId) o;
        return Objects.equals(idTeacher, that.idTeacher) &&
                Objects.equals(idTime, that.idTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, idTime);
    }
}
