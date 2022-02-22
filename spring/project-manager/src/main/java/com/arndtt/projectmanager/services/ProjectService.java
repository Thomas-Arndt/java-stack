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

    // Returns a single project by ID if it is present in the database
    public Project oneProject(Long id) {
        Optional<Project> potentialProject = projectRepo.findById(id);
        if(potentialProject.isPresent()) {
            return potentialProject.get();
        }
        return null;
    }

    // Returns a list of projects that the user has not yet joined
    public List<Project> availableProjects(User user) {
        return projectRepo.findByUsersNotContaining(user);
    }

    // Saves/updates a project to the database
    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }

    // Deletes a project and all associated tasks from the database
    public void deleteProject(Project project) {
        for(Task task : project.getTasks()) {
            taskRepo.delete(task);
        }
        projectRepo.delete(project);
    }
}
