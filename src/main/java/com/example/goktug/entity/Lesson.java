package com.example.goktug.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "LESSON")
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lessonName;
    private String lessonDescription;
    private int examCount;

    private int credits;

    @ManyToOne
    @JoinColumn(name = "teacher_id") // Öğretmenle ilişki
    private Teacher teacher;
    @ElementCollection
    @CollectionTable(name = "lesson_exam_types", joinColumns = @JoinColumn(name = "lesson_id"))
    @Column(name = "exam_type")
    private List<String> examTypes;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Score> scores;
}
