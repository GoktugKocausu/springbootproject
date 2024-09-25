package com.example.goktug.DTO;

import lombok.Data;

@Data
public class ScoreDTO {
    private Long id;
    private int score;
    private Long studentId; // Reference by ID to avoid deep nesting
    private Long teacherId; // Reference by ID to avoid deep nesting
    private Long lessonId; // Reference by ID to avoid deep nesting
}
