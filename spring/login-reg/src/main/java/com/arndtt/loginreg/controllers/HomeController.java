package com.arndtt.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.arndtt.loginreg.models.LoginUser;
import com.arndtt.loginreg.models.User;
import com.arndtt.loginreg.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
        BindingResult result, Model model, HttpSession session) {
        
        User user = userService.register(newUser, result);
        if(result.hasErrors() || user == null) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("uuid", user.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
        BindingResult result, Model model, HttpSession session) {
        
        User user = userService.login(newLogin, result);
        if(result.hasErrors() || user==null) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("uuid", user.getId());
        return "redirect:/dashboard";

        }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uuid");
        return "redirect:/";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if(session.getAttribute("uuid")==null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        model.addAttribute("user", user);
        return "dashboard.jsp";
    }

}
