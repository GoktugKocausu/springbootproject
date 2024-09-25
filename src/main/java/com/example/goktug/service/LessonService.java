package com.example.goktug.service;

import com.example.goktug.DTO.LessonCreateDto;
import com.example.goktug.DTO.LessonDTO;
import com.example.goktug.DTO.LessonScoreUpdateDto;
import com.example.goktug.entity.Lesson;
import com.example.goktug.utils.RENUM;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface LessonService {

    public Lesson lessonAdd(LessonCreateDto lessonDTO);
    public Lesson lessonUpdate(LessonCreateDto lessonCreateDto);
    String lessonDelete(Long id);
    List<Lesson> lessonList();
    public Lesson lessonFingById(Long id);


}
