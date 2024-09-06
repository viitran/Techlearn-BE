package com.techzen.techlearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "tbl_course")
public class CourseEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<SubmissionEntity> submissions;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<AssignmentEntity> assignments;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
