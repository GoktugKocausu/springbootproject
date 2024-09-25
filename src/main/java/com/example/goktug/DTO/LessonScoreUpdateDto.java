package com.example.goktug.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LessonScoreUpdateDto {
    private Long studentId;
    private Long lessonId;
    private Long teacherId;
    private int score;
}
