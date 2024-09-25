package com.example.goktug.service.serviceImp;

import java.util.*;

import com.example.goktug.DTO.TeacherDTO;
import com.example.goktug.entity.Teacher;
import com.example.goktug.repository.TeacherRepository;
import com.example.goktug.service.TeacherService;
import com.example.goktug.utils.RENUM;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;


    }

    @Override
    public HashMap<RENUM,Teacher> addTeacher(TeacherDTO teacherDTO) {
        HashMap hm = new HashMap<>();
        Teacher teacher= new Teacher();


        try {
            teacher.setId(null);
            teacher.setEmail(teacherDTO.getEmail());
            teacher.setFirstName(teacherDTO.getFirstName());
            teacher.setLastName(teacherDTO.getLastName());

            Teacher tc= teacherRepository.save(teacher);
            hm.put(RENUM.STATUS,true);
            hm.put(RENUM.RESULT,tc);
            return hm;
        }catch (Exception e){
            e.getStackTrace();
            hm.put(RENUM.STATUS,false);
            hm.put(RENUM.RESULT,e.getMessage());
            return hm;
        }




    }

    @Override
    public String deleteTeacher(Long id) {
        // Öğretmeni ID ile arıyoruz
        Optional<Teacher> teacher = teacherRepository.findById(id);

        if (teacher.isPresent()) {

            teacherRepository.deleteById(id);
            return  "Teacher deleted successfully";
        } else {
            // Öğretmen bulunamazsa hata mesajı
            return  "Teacher couldn't deleted successfully";
        }
    }

    @Override
    public ResponseEntity<HashMap<RENUM,Object>> updateTeacher(TeacherDTO teacherDTO) {

        HashMap<RENUM, Object> hm = new LinkedHashMap<>();
        Teacher teacher= new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setEmail(teacherDTO.getEmail());


        try{
            Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherDTO.getId());
            if (optionalTeacher.isPresent()) {
                hm.put(RENUM.STATUS,true);
                hm.put(RENUM.RESULT,teacher);
                teacherRepository.saveAndFlush(teacher);
                return new ResponseEntity<>(hm, HttpStatus.OK);
            }else {
                hm.put(RENUM.STATUS,false);
                hm.put(RENUM.RESULT,"HATA VAR");
                return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);

            }



        } catch (Exception e) {
            e.getStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Teacher getById(Long Id){

        return teacherRepository.findById(Id).get();
    }

    @Override
    public ResponseEntity<?> findByIdTeacher(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();

        try {
            Optional<Teacher> optionalTeacher = teacherRepository.findById(id);

            if (optionalTeacher.isPresent()) {
                hm.put(RENUM.STATUS.name(), true);
                hm.put(RENUM.RESULT.name(), optionalTeacher.get());
                return new ResponseEntity<>(hm, HttpStatus.OK);
            } else {
                hm.put(RENUM.STATUS.name(), false);
                hm.put(RENUM.MESSAGE.name(), "Teacher yok");
                return new ResponseEntity<>(hm, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            e.printStackTrace();


            hm.put(RENUM.STATUS.name(), false);
            hm.put(RENUM.MESSAGE.name(), "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity findAllTeachers() {

        HashMap hm = new LinkedHashMap<>();

        try {
            List<Teacher> teacher = teacherRepository.findAll();

            if (!teacher.isEmpty()) {

                hm.put(RENUM.STATUS.name(), true);
                hm.put(RENUM.RESULT.name(), teacher);
                return new ResponseEntity<>(hm, HttpStatus.OK);
            } else {

                hm.put(RENUM.STATUS.name(), false);
                hm.put(RENUM.MESSAGE.name(), "Hiç öğretmen bulunamadı");
                return new ResponseEntity<>(hm, HttpStatus.NOT_FOUND);


            }
            }catch (Exception e){
            e.printStackTrace();

            hm.put(RENUM.STATUS.name(), false);
            hm.put(RENUM.MESSAGE.name(), "An error occurred: " + e.getMessage());
            return new ResponseEntity<>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
    }