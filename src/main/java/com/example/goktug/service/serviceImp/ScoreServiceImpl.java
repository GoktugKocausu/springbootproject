package com.example.goktug.service.serviceImp;

import com.example.goktug.DTO.LessonScoreUpdateDto;
import com.example.goktug.DTO.ScoreUpdateDto;
import com.example.goktug.entity.Lesson;
import com.example.goktug.entity.Score;
import com.example.goktug.entity.Student;
import com.example.goktug.entity.Teacher;
import com.example.goktug.repository.LessonRepository;
import com.example.goktug.repository.ScoreRepository;
import com.example.goktug.repository.StudentRepository;
import com.example.goktug.repository.TeacherRepository;
import com.example.goktug.service.ScoreService;
import com.example.goktug.service.StudentService;
import com.example.goktug.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

public class ScoreServiceImpl implements ScoreService {
    private final LessonRepository lessonRepository;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(LessonRepository lessonRepository, ScoreRepository scoreRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, TeacherService teacherService, StudentService studentService) {
        this.lessonRepository = lessonRepository;
        this.scoreRepository = scoreRepository;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @Override
    public Score updateScore(ScoreUpdateDto lessonDTO) throws IllegalAccessException {

        Lesson lesson = lessonRepository.findById(lessonDTO.getLessonId()).get();
        Teacher teacher = teacherService.getById(lessonDTO.getTeacherId());
        Student student =studentService.findById(lessonDTO.getStudentId());

        lesson.setTeacher(teacher);
        Score score = new Score();
        LocalDate localDate = LocalDate.now();
        score.setExamSaveDate(localDate);
        score.setTeacher(teacher);
        score.setStudent(student);
        score.setLesson(lesson);
        score.setScore(lessonDTO.getScore());
        scoreRepository.save(score);
        return score;
    }

    @Override
    public Score deleteScore(Long id) throws IllegalAccessException {
        return null;
    }

}
