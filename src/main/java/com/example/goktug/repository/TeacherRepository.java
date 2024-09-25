package com.example.goktug.repository;

import com.example.goktug.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface
TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findById(Long aLong);

   // @Query(value = "SELECT * FROM TEACHER WHERE ID =: id ", nativeQuery = true)
    // Optional<Teacher> findByIdFromQuery(Long id);




}
