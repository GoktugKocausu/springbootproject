package com.example.goktug.DTO;

import lombok.Data;

@Data
public class ScoreUpdateDto {


        private Long studentId;
        private Long lessonId;
        private Long teacherId;
        private int score;
    }

