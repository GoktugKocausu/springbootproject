package com.example.goktug.service;
import com.example.goktug.DTO.StudentCreateDto;
import com.example.goktug.DTO.StudentDTO;

import com.example.goktug.entity.Student;
import com.example.goktug.utils.RENUM;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface StudentService {

    public HashMap<RENUM, Student> addStudent(StudentCreateDto studentDTO);
    HashMap<RENUM, Student> updateStudent(Student student); //BUnda id yi içerden  sorgu ile bulaacaksan DTO kullan ama id yi jsonbody ile göndereceksen Student Class ının verilerini kullan
    Student deleteStudent(Long id);
    Student getAllStudent();

    Student findById(Long studentId) throws IllegalAccessException;
    Student studentUpdate(StudentDTO studentDTO);

}