package com.arndtt.projectmanager.repositories;

import java.util.List;

import com.arndtt.projectmanager.models.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
}
