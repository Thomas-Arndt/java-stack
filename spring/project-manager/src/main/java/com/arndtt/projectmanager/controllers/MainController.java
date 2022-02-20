package com.arndtt.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.arndtt.projectmanager.models.Project;
import com.arndtt.projectmanager.models.Task;
import com.arndtt.projectmanager.models.User;
import com.arndtt.projectmanager.services.ProjectService;
import com.arndtt.projectmanager.services.TaskService;
import com.arndtt.projectmanager.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class MainController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        List<Project> availableProjects = projectService.availableProjects(user);
        model.addAttribute("availableProjects", availableProjects);
        model.addAttribute("user", user);
        return "dashboard.jsp";
    }

    // --------------- Project Details -----------------
    @GetMapping("/projects/{id}")
    public String projectDetails(@PathVariable("id") Long projectId, Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        Project project = projectService.oneProject(projectId);
        model.addAttribute("project", project);
        return "projectDetails.jsp";
    }

    // --------------- New Project Form ----------------
    @GetMapping("/projects/new")
    public String projectForm(@ModelAttribute("project") Project project, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        return "newProjectForm.jsp";
    }
    
    @PostMapping("/projects/new")
    public String processProjectForm(@Valid @ModelAttribute("project") Project project,
        BindingResult result, HttpSession session) {
        
        if(result.hasErrors()) {
            return "newProjectForm.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        project.setLead(user);
        user.getProjects().add(project);
        projectService.saveProject(project);
        userService.saveUser(user);
        return "redirect:/dashboard";
    }

    // ---------------- Edit Project Details ----------------
    @GetMapping("/projects/edit/{id}")
    public String editProject(@PathVariable("id") Long projectId, Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        Project project = projectService.oneProject(projectId);
        model.addAttribute("project", project);
        return "editProjectForm.jsp";
    }

    // ---------------- Process Edit Form -----------------
    @PutMapping("/projects/edit/{id}")
    public String processEditProject(@PathVariable("id") Long projectId,
        @Valid @ModelAttribute("project") Project project,
        BindingResult result) {

        if(result.hasErrors()) {
            return "editProjectForm.jsp";
        }
        Project dbProject = projectService.oneProject(projectId);
        dbProject.setTitle(project.getTitle());
        dbProject.setDescription(project.getDescription());
        dbProject.setDueDate(project.getDueDate());
        projectService.saveProject(dbProject);
        return "redirect:/dashboard";
    }

    // ---------------- Join Project -------------------
    @PutMapping("/projects/{projectId}/join")
    public String joinTeam(@PathVariable("projectId") Long projectId, HttpSession session) {
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        Project project = projectService.oneProject(projectId);
        user.getProjects().add(project);
        project.getUsers().add(user);
        userService.saveUser(user);
        projectService.saveProject(project);
        return "redirect:/dashboard";
    }

    // ---------------- Leave Project -------------------
    @PutMapping("/projects/{projectId}/leave")
    public String leaveTeam(@PathVariable("projectId") Long projectId, HttpSession session) {
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        Project project = projectService.oneProject(projectId);
        user.getProjects().remove(project);
        project.getUsers().remove(user);
        userService.saveUser(user);
        projectService.saveProject(project);
        return "redirect:/dashboard";
    }

    // ---------------- Delete Project ------------------
    @DeleteMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable("id") Long projectId, HttpSession session) {
        Project project = projectService.oneProject(projectId);
        if(session.getAttribute("uuid") != project.getLead().getId()) {
            return "redirect:/dashboard";
        }
        projectService.deleteProject(project);
        return "redirect:/dashboard";
    }

    // ---------------- Task Form / View Tasks -----------------
    @GetMapping("/projects/{id}/tasks")
    public String projectTasks(@PathVariable("id") Long projectId, Model model,
        @ModelAttribute("task") Task task, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        Project project = projectService.oneProject(projectId);
        model.addAttribute("project", project);
        return "projectTasks.jsp";
    }

    // ---------------- Add Task --------------------
    @PostMapping("/projects/{id}/tasks")
    public String processTaskForm(@PathVariable("id") Long projectId,
        @Valid @ModelAttribute("task") Task task,
        BindingResult result, Model model, HttpSession session) {
        
        Project project = projectService.oneProject(projectId);
        if(result.hasErrors()) {
            model.addAttribute("project", project);
            return "projectTasks.jsp";
        }
        User creator = userService.oneUser((long) session.getAttribute("uuid"));
        task.setCreator(creator);
        task.setProject(project);
        project.getTasks().add(task);
        taskService.saveTask(task);
        projectService.saveProject(project);
        return "redirect:/projects/"+projectId+"/tasks";
    }
}
