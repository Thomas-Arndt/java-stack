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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormService dormService;

    @GetMapping("/students/new")
    public String studentForm(@ModelAttribute("student") Student student) {
        return "studentForm.jsp";
    }

    @PostMapping("/students")
    public String createStudent(@Valid @ModelAttribute("student") Student student,
        BindingResult result) {
        if(result.hasErrors()) {
            return "studentForm.jsp";
        } else {
            studentService.createStudent(student);
            return "redirect:/dorms";
        }
    }

    @PutMapping("/students/assign")
    public String assignStudent(@RequestParam("dormId") Long dormId,
        @RequestParam("studentId") Long studentId,
        Model model) {
            Student student = studentService.oneStudent(studentId);
            Dorm dorm = dormService.oneDorm(dormId);
            student.setDorm(dorm);
            studentService.updateStudent(student);
            List<Student> allStudents = studentService.allStudents();
            model.addAttribute("currentDorm", dorm);
            model.addAttribute("allStudents", allStudents);
            return "redirect:/dorm/"+dormId;
    }

    @PutMapping("students/remove")
    public String removeStudent(@RequestParam("dormId") Long dormId,
        @RequestParam("studentId") Long studentId,
        Model model) {
            Student student = studentService.oneStudent(studentId);
            Dorm dorm = dormService.oneDorm(dormId);
            student.setDorm(null);
            studentService.updateStudent(student);
            List<Student> allStudents = studentService.allStudents();
            model.addAttribute("currentDorm", dorm);
            model.addAttribute("allStudents", allStudents);
            return "redirect:/dorm/"+dormId;
        }
}
