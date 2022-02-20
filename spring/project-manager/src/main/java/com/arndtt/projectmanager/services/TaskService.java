package com.arndtt.projectmanager.services;

import com.arndtt.projectmanager.models.Task;
import com.arndtt.projectmanager.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepo;

    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }
}
