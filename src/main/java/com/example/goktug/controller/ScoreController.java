package com.example.goktug.controller;

import com.example.goktug.DTO.LessonScoreUpdateDto;
import com.example.goktug.DTO.ScoreUpdateDto;
import com.example.goktug.entity.Lesson;
import com.example.goktug.entity.Score;
import com.example.goktug.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PutMapping("/add")
    public ResponseEntity<Score> updateScore(@RequestBody ScoreUpdateDto lessonDTO) throws IllegalAccessException {
        return ResponseEntity.ok(scoreService.updateScore(lessonDTO));
    }

}
