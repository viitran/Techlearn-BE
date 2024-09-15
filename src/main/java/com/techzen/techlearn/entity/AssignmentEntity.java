package com.techzen.techlearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzen.techlearn.enums.SubmitStatus;
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

    @Column(name = "description", columnDefinition = "NTEXT")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SubmitStatus status;

    @ManyToOne()
    @JoinColumn(name = "chapter_id")
    @JsonIgnore
    private ChapterEntity chapter;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
