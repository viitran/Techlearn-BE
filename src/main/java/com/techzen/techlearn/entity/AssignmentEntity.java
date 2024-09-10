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
@Table(name = "tbl_assignment")
public class AssignmentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<SubmitEntity> submissions;

    @ManyToMany
    @JoinTable(
            name = "tbl_assignment_user",
            joinColumns = @JoinColumn(name = "assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<UserEntity> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;

    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<SubmitFeedbackEntity> feedBacks;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
