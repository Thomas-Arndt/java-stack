package com.arndtt.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.arndtt.projectmanager.models.LoginUser;
import com.arndtt.projectmanager.models.User;
import com.arndtt.projectmanager.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

// --------------- Registration Routes ---------------
    @GetMapping("/register")
    public String registration(@ModelAttribute("newUser") User user) {
        return "register.jsp";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result, Model model, HttpSession session) {

        if (result.hasErrors()) {
            return "register.jsp";
        }
        User user = userService.register(newUser, result);
        if (user == null) {
            return "register.jsp";
        }
        session.setAttribute("uuid", user.getId());
        return "redirect:/dashboard";
    }
        
// --------------- Login Routes ---------------
    @GetMapping("/")
    public String login(@ModelAttribute("loginUser") LoginUser loginUser) {
        return "login.jsp";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
    BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "login.jsp";
        }
        User user = userService.login(loginUser, result);
        if(user == null) {
            return "login.jsp";
        }
        session.setAttribute("uuid", user.getId());
        return "redirect:/dashboard";
    }

    // --------------- Logout ---------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uuid");
        return "redirect:/";
    }
}
