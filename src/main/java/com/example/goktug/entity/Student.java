package com.example.goktug.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "STUDENT")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Ensure correct strategy
    private Long id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String studentfirstName;

    @Column(name = "LASTNAME", nullable = false)
    private String studentlastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String studendEmail;

    @Column(name = "BIRTHDAY")
    private LocalDate dateOfBirth;

    @Column(name = "LEVEL")
    @Size(min = 6, max = 12)
    private Long level;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Score> scores = new HashSet<>(); // Ensure initialization to avoid null
}
