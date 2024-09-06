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
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "time_start")
        private Time timeStart;

        @Column(name = "time_end")
        private Time timeEnd;

        public CalendarEntity(Integer idTime) {
                this.id = idTime;
        }
}
