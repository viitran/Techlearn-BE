package com.techzen.techlearn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technical_teacher")
public class TechnicalEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_teacher", nullable = false)
    private TeacherEntity teacherEntity;

}
