package com.example.goktug.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDto {
    private String studentName;
    private String studentSurname;
    private String studentEmail;
    private Long level;
}
