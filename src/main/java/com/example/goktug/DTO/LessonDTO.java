package com.example.goktug.DTO;

import lombok.Data;

import java.util.List;

@Data
public class LessonDTO {
    private String name;
    private String description; // Description field
    private int credits; // Credits field
    private int examCount;
    private List<String> examTypes; // Örneğin: ["Midterm", "Final", "Quiz"]

    private List<ScoreDTO> scores; // Include scores as a list of ScoreDTO
}
