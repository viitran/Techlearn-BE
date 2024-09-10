package com.techzen.techlearn.entity;

import com.techzen.techlearn.enums.SubmitStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "tbl_submission")
public class SubmitEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "link")
    private String link;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SubmitStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "assignment_id")
     private AssignmentEntity assignment;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
