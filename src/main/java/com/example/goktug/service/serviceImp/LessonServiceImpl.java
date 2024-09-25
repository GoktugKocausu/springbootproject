package com.example.goktug.service.serviceImp;

import com.example.goktug.DTO.LessonCreateDto;
import com.example.goktug.DTO.LessonDTO;
import com.example.goktug.DTO.LessonScoreUpdateDto;
import com.example.goktug.DTO.TeacherDTO;
import com.example.goktug.entity.Lesson;
import com.example.goktug.entity.Score;
import com.example.goktug.entity.Student;
import com.example.goktug.entity.Teacher;
import com.example.goktug.repository.LessonRepository;
import com.example.goktug.repository.ScoreRepository;
import com.example.goktug.service.LessonService;
import com.example.goktug.service.StudentService;
import com.example.goktug.service.TeacherService;
import com.example.goktug.utils.RENUM;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ScoreRepository scoreRepository;


    @Override
    public Lesson lessonAdd(LessonCreateDto lessonDTO) {
        Teacher teachers= teacherService.getById(lessonDTO.getTeacherId());
        Lesson lesson = new Lesson();
        lesson.setId(null);
        lesson.setTeacher(teachers);
        lesson.setLessonName(lessonDTO.getName());
        lesson.setLessonDescription(lessonDTO.getDescription());
        lesson.setCredits(lessonDTO.getCredits());
        lesson.setExamCount(lessonDTO.getExamCount());

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson lessonUpdate(LessonCreateDto lessonCreateDto) {
        Optional<Lesson> existingLessonOpt = lessonRepository.findById(lessonCreateDto.getId());
        Teacher teachers= teacherService.getById(lessonCreateDto.getTeacherId());
        if (existingLessonOpt.isPresent()) {
            Lesson existingLesson = existingLessonOpt.get();
            existingLesson.setTeacher(teachers);
            existingLesson.setLessonName(lessonCreateDto.getName());
            existingLesson.setLessonDescription(lessonCreateDto.getDescription());
            existingLesson.setCredits(lessonCreateDto.getCredits());
/*            existingLesson.setExamCount(lessonCreateDto.getExamCount());
            existingLesson.setExamTypes(lessonCreateDto.getExamTypes());*/

            return lessonRepository.save(existingLesson);

        }else{
            throw new EntityNotFoundException("Lesson not found with id: " + lessonCreateDto.getId());
        }
    }

    @Override
    public String lessonDelete(Long id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
            return "deleted";
        } else {
            return "not deleted";
        }
    }

    @Override
    public List<Lesson> lessonList() {

        return lessonRepository.findAll();
    }

    @Override
    public Lesson lessonFingById(Long id) {

        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with id: " + id));
    }


}
