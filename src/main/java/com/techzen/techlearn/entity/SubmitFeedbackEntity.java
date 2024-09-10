package com.techzen.techlearn.entity;

import com.techzen.techlearn.enums.FeedbackType;
import com.techzen.techlearn.enums.SubmitStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "tbl_submit_feedback")
public class SubmitFeedbackEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description",columnDefinition = "MEDIUMTEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private LocalDateTime feedbackDate;

    @Column(nullable = false)
    private boolean isAiGenerated;

    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType = FeedbackType.SUBMIT;

    @Enumerated(EnumType.STRING)
    private SubmitStatus status;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
