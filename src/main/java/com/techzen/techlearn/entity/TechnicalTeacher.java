package com.techzen.techlearn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technical_teacher")
public class TechnicalTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "technicalTeacher")
    private List<TeacherChapter> teacherChapters;
}
