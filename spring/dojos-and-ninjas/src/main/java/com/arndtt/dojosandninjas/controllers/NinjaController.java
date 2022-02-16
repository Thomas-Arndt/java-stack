package com.arndtt.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import com.arndtt.dojosandninjas.models.Dojo;
import com.arndtt.dojosandninjas.models.Ninja;
import com.arndtt.dojosandninjas.services.DojoService;
import com.arndtt.dojosandninjas.services.NinjaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NinjaController {
    
    @Autowired
    private DojoService dojoService;

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> allDojos = dojoService.allDojos();
        model.addAttribute("allDojos", allDojos);
        return "ninjaForm.jsp";
    }

    @PostMapping("/ninjas")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
        BindingResult result,
        Model model) {
        if(result.hasErrors()) {
            List<Dojo> allDojos = dojoService.allDojos();
            model.addAttribute("allDojos", allDojos);
            return "ninjaForm.jsp";
        }
        else {
            Ninja newNinja = ninjaService.createNinja(ninja);
            return "redirect:/dojos/"+newNinja.getDojo().getId();
        }
    }
}
