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
@Table(name = "tbl_user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SubmitEntity> submissions;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SubmitFeedbackEntity> feedBacks;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<AssignmentEntity> assignments;
}
