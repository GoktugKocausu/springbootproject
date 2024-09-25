package com.example.goktug.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
