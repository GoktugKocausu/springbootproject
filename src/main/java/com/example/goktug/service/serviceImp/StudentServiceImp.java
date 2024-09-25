package com.example.goktug.service.serviceImp;


import com.example.goktug.DTO.StudentCreateDto;
import com.example.goktug.DTO.StudentDTO;
import com.example.goktug.DTO.TeacherDTO;
import com.example.goktug.entity.Student;
import com.example.goktug.entity.Teacher;
import com.example.goktug.repository.StudentRepository;
import com.example.goktug.service.StudentService;
import com.example.goktug.utils.RENUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService {

    final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public HashMap<RENUM, Student> addStudent(StudentCreateDto studentDTO) {
        HashMap hm = new HashMap<>();
        Student student = new Student();

        try {

            student.setId(null);
            student.setStudendEmail(studentDTO.getStudentEmail());
            student.setStudentfirstName(studentDTO.getStudentName());
            student.setStudentlastName(studentDTO.getStudentSurname());
            student.setDateOfBirth(LocalDate.parse("1970-01-01"));
            student.setLevel(studentDTO.getLevel());


            Student savedStudent = studentRepository.save(student);
            hm.put(RENUM.STATUS,true);
            hm.put(RENUM.RESULT, savedStudent);
            return hm;
        } catch (Exception e) {
            e.printStackTrace();
            hm.put(RENUM.STATUS, false);
            hm.put(RENUM.RESULT, e.getMessage());
            return hm;
        }
    }

    @Override
    public HashMap<RENUM, Student> updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(Long id) {
        return null;
    }

    @Override
    public Student getAllStudent() {
        return null;
    }

    @Override
    public Student findById(Long studentId) throws IllegalAccessException {

        return studentRepository.findById(studentId).orElseThrow(() -> new IllegalAccessException("Student Bulunamadı"));
    }

    public Student studentUpdate(StudentDTO studentDTO){
        return null;
    }
}

