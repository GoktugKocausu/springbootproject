package com.example.goktug.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonCreateDto {

    private Long id;
    private String name;
    private String description;
    private int credits;
    private Long teacherId;
    private int examCount;
    private List<String> examTypes;

}
