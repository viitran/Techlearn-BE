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
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @JoinColumn(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "avatar")
    private String avatar;
}
