package com.example.knowledgekite.service;

import com.example.knowledgekite.domain.Course;
import com.example.knowledgekite.domain.Module;
import com.example.knowledgekite.repository.CourseRepository;
import com.example.knowledgekite.repository.ModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {
    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModuleRepository moduleRepository;

    public void createCourse(Course payload) {
        courseRepository.save(payload);
    }

    public List<Course> getAllCourses() {
        log.info("Getting all courses");
        Iterable<Course> courses = courseRepository.findAll();
        return StreamSupport.stream(courses.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Course getCourseFor(Long courseId) {
        log.info("Getting course with id ({})", courseId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Invalid courseId ("+ courseId +")"));
        course.setModules(moduleRepository.findByCourse_Id(courseId));
        return course;
    }

    public void createModule(Long courseId, Module module) {
        log.info("Creating new module for course with id ({})", courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Invalid courseId " + courseId));
        module.setCourse(course);
        moduleRepository.save(module);
    }
}
