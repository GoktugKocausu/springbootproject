package com.example.goktug.service;

import com.example.goktug.DTO.LessonScoreUpdateDto;
import com.example.goktug.DTO.ScoreUpdateDto;
import com.example.goktug.entity.Lesson;
import com.example.goktug.entity.Score;

public interface ScoreService {
    Score updateScore(ScoreUpdateDto lessonDTO) throws IllegalAccessException;
    Score deleteScore(Long id) throws IllegalAccessException;
}
