package com.arndtt.dojosandninjas.controllers;

import javax.validation.Valid;

import com.arndtt.dojosandninjas.models.Dojo;
import com.arndtt.dojosandninjas.services.DojoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DojoController {

    @Autowired
    private DojoService dojoService;
    
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo,
        BindingResult result) {
        return "newDojo.jsp";
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.oneDojo(id);
        model.addAttribute("dojo", dojo);
        return "showDojo.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
        BindingResult result) {
        if(result.hasErrors()) {
            return "newDojo.jsp";
        } else {
            Dojo newDojo = dojoService.create(dojo);
            return "redirect:/dojos/"+newDojo.getId();
        }
    }
}
