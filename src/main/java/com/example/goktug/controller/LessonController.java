package com.example.goktug.controller;

import com.example.goktug.DTO.LessonCreateDto;
import com.example.goktug.entity.Lesson;
import com.example.goktug.service.LessonService;
import com.example.goktug.service.serviceImp.LessonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    final LessonService lessonService;

    public LessonController(LessonService lessonService, LessonServiceImpl lessonServiceimpl) {
        this.lessonService = lessonService;
    }


    @PostMapping("/add")
    public ResponseEntity<Lesson> addLesson(@RequestBody LessonCreateDto lessonDTO) {
        return ResponseEntity.ok(lessonService.lessonAdd(lessonDTO));

    }
    @PutMapping("/update")
    public ResponseEntity<Lesson> updateLesson(@RequestBody LessonCreateDto lessonCreateDto) {
        return ResponseEntity.ok(lessonService.lessonUpdate(lessonCreateDto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.lessonDelete(lesson.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Lesson lesson = lessonService.lessonFingById(id);
        return ResponseEntity.ok(lesson);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Lesson>> lessonList() {
        List<Lesson> lessons = lessonService.lessonList();
        return ResponseEntity.ok(lessons);
    }
}
