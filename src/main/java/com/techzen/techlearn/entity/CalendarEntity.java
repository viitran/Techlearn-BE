package com.techzen.techlearn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calendar")
public class CalendarEntity {
        @Id
        @JoinColumn(columnDefinition = "BINARY(16)")
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @JoinColumn(name = "time_start")
        private Time timeStart;

        @JoinColumn(name = "time_end")
        private Time timeEnd;
}
