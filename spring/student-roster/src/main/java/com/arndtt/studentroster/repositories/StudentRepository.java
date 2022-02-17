package com.arndtt.studentroster.repositories;

import java.util.List;

import com.arndtt.studentroster.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();

    List<Student> findByDormIsNull();
}
