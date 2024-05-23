package com.example.knowledgekite.repository;

import com.example.knowledgekite.domain.UserCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, UUID> {
}
