package com.example.goktug.controller;

import com.example.goktug.DTO.TeacherDTO;
import com.example.goktug.entity.Teacher;
import com.example.goktug.service.TeacherService;
import com.example.goktug.utils.RENUM;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PutMapping(value = "/update", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<RENUM,Object>> updateTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.updateTeacher(teacherDTO);

    }


    @PostMapping("/add")
    public ResponseEntity<HashMap<RENUM,Teacher>> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.ok(teacherService.addTeacher(teacherDTO));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {

        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }

    @GetMapping("/findid/{id}")
    public ResponseEntity<TeacherDTO> findByIdTeacher(@PathVariable Long id) {
        return teacherService.findByIdTeacher(id);

    }

    @GetMapping("/list")
    public ResponseEntity<?> listAllTeachers() {
        // Servis metodunu çağır ve sonucu döndür
        return teacherService.findAllTeachers();
    }
}