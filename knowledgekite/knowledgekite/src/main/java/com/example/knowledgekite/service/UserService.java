package com.example.knowledgekite.service;

import com.example.knowledgekite.domain.User;
import com.example.knowledgekite.domain.UserCourse;
import com.example.knowledgekite.repository.CourseRepository;
import com.example.knowledgekite.repository.UserCourseRepository;
import com.example.knowledgekite.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserCourseRepository userCourseRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    public UserCourse enrollUser(Long userId, Long courseId) {
        UserCourse userCourse = new UserCourse();
        userCourse.setCourse(courseRepository.findById(courseId).orElseThrow(EntityNotFoundException::new));
        userCourse.setUser(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
        return userCourseRepository.save(userCourse);
    }

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

}
