package com.arndtt.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import com.arndtt.studentroster.models.Dorm;
import com.arndtt.studentroster.models.Student;
import com.arndtt.studentroster.services.DormService;
import com.arndtt.studentroster.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DormController {

    @Autowired
    private DormService dormService;

    @Autowired
    private StudentService studentService;
    
    @GetMapping("/dorms")
    public String showAllDojos(Model model) {
        List<Dorm> allDorms = dormService.findAllDorms();
        model.addAttribute("allDorms", allDorms);
        return "allDorms.jsp";
    }

    @GetMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "dormForm.jsp";
    }

    @PostMapping("/dorms")
    public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if(result.hasErrors()) {
            return "dormForm.jsp";
        } else {
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }

    @GetMapping("/dorm/{id}")
    public String dormRoster(@PathVariable("id") Long id, Model model) {
        Dorm currentDorm = dormService.oneDorm(id);
        List<Student> allStudents = studentService.allStudents();
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("currentDorm", currentDorm);
        return "dormRoster.jsp";
    }

}
