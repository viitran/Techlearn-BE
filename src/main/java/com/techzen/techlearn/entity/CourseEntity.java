package com.techzen.techlearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<SubmitEntity> submissions;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<AssignmentEntity> assignments;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<ChapterEntity> chapters;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
