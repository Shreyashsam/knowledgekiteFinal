package com.example.knowledgekite.repository;

import com.example.knowledgekite.domain.Module;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ModuleRepository extends CrudRepository<Module, Long> {
    Set<Module> findByCourse_Id(Long courseId);
}
