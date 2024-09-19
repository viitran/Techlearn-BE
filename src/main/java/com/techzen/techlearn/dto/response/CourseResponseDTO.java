package com.techzen.techlearn.dto.response;

import com.techzen.techlearn.entity.ChapterEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponseDTO {
    private long id;
    private String name;
    private String image;
    private String description;
    private String time;
    private List<ChapterEntity> listChapter;

}



