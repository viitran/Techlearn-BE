package com.techzen.techlearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzen.techlearn.enums.SubmissionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "tbl_submission")
public class SubmissionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "link")
    private String link;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private SubmissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "submission")
    @JsonIgnore
    private List<AssignmentEntity> assignments;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
