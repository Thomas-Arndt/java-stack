package com.arndtt.studentroster.repositories;

import java.util.List;

import com.arndtt.studentroster.models.Dorm;

import org.springframework.data.repository.CrudRepository;

public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}
