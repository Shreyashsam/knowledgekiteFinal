package com.example.knowledgekite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "CourseName should not be null")
    @NotBlank(message = "CourseName should not be blank")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private CourseType type = CourseType.FREE;

    private Double fees = 0.0;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    Set<UserCourse> userCourses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    Set<Module> modules;

}

enum CourseType {
    PAID,
    FREE
}
