package com.arndtt.projectmanager.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.projectmanager.models.Project;
import com.arndtt.projectmanager.models.Task;
import com.arndtt.projectmanager.models.User;
import com.arndtt.projectmanager.repositories.ProjectRepository;
import com.arndtt.projectmanager.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private TaskRepository taskRepo;

    public Project oneProject(Long id) {
        Optional<Project> potentialProject = projectRepo.findById(id);
        if(potentialProject.isPresent()) {
            return potentialProject.get();
        }
        return null;
    }

    public List<Project> availableProjects(User user) {
        return projectRepo.findByUsersNotContaining(user);
    }

    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }

    public void deleteProject(Project project) {
        for(Task task : project.getTasks()) {
            taskRepo.delete(task);
        }
        projectRepo.delete(project);
    }
}
