package com.example.goktug.controller;

import com.example.goktug.DTO.StudentCreateDto;
import com.example.goktug.DTO.StudentDTO;
import com.example.goktug.entity.Student;
import com.example.goktug.entity.Teacher;
import com.example.goktug.utils.RENUM;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.goktug.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<HashMap<RENUM, Student>> addStudent(@RequestBody StudentCreateDto studentDTO) {
        return ResponseEntity.ok( studentService.addStudent(studentDTO));
    }

}
