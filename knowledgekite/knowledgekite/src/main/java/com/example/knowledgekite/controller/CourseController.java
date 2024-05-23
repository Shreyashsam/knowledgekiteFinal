package com.example.knowledgekite.controller;

import com.example.knowledgekite.domain.Course;
import com.example.knowledgekite.domain.Module;
import com.example.knowledgekite.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/all")
    List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}/modules")
    List<Module> getModulesForCourse(@PathVariable("id") Long id) {
        Course course = courseService.getCourseFor(id);
        if (course != null) {
            return course.getModules().stream().collect(Collectors.toList()); // Assuming Course has a getter for modules
        } else {

            return List.of(); // Empty list
        }
    }
    @PostMapping("/{courseId}/modules")
    @ResponseStatus(HttpStatus.CREATED) // Indicate successful creation
    public Module addModuleToCourse(@PathVariable("courseId") Long courseId,
                                    @Valid @RequestBody Module module) {
        courseService.createModule(courseId,module);
        return module;
    }


    @GetMapping("/{id}")
    Course getCourseFor(@PathVariable("id") Long id) {
        return courseService.getCourseFor(id);
    }
}
