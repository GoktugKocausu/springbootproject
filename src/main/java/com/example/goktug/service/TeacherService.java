package com.example.goktug.service;

import com.example.goktug.DTO.TeacherDTO;
import com.example.goktug.entity.Teacher;
import com.example.goktug.utils.RENUM;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface TeacherService {

    String deleteTeacher(Long id);
    public ResponseEntity<HashMap<RENUM,Object>> updateTeacher(TeacherDTO teacherDTO);

    Teacher getById(Long Id);

    public ResponseEntity findByIdTeacher(Long id);
    public ResponseEntity findAllTeachers();

    HashMap<RENUM,Teacher> addTeacher(TeacherDTO teacherDTO);
}
