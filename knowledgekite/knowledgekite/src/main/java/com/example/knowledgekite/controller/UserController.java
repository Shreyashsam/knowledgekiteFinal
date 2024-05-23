package com.example.knowledgekite.controller;

import com.example.knowledgekite.domain.User;
import com.example.knowledgekite.domain.UserCourse;
import com.example.knowledgekite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// we can have all the endpoints of user actions like login, course enroll,
// course completion, participation in quiz, etc.
//If we have more detailing about user, we can have separate controller like UserCourseManagement
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/course/{courseId}/enroll")
    UserCourse enrollForCourse(@PathVariable Long userId, @PathVariable Long courseId){
        return userService.enrollUser(userId, courseId);
    }

    @GetMapping("/all")
    List<User> getUsers(){
        return userService.getUsers();
    }


}
