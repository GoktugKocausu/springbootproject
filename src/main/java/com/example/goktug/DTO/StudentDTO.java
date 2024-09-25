package com.example.goktug.DTO;

import com.example.goktug.entity.Score;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class StudentDTO {
    private String studentName;
    private String studentSurname;
    private String studentEmail;
    //private LocalDate dateOfBirth;
    private Long level;
    private Set<Score> score;
}
