package com.example.goktug.repository;


import com.example.goktug.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface
LessonRepository extends JpaRepository<Lesson, Long> {

}
