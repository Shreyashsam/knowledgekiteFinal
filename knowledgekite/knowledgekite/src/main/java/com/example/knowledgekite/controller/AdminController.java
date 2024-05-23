package com.example.knowledgekite.controller;

import com.example.knowledgekite.domain.Course;
import com.example.knowledgekite.domain.Module;
import com.example.knowledgekite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    CourseService courseService;

    @PostMapping("/course")
    ResponseEntity<Object> createCourse(@RequestBody Course payload) {
        courseService.createCourse(payload);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/course/{course-id}/module")
    ResponseEntity<Object> createModule(@PathVariable("course-id") Long courseId, @RequestBody Module module) {
        courseService.createModule(courseId, module);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
