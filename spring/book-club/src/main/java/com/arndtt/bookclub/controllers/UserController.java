package com.arndtt.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.arndtt.bookclub.models.Book;
import com.arndtt.bookclub.models.LoginUser;
import com.arndtt.bookclub.models.User;
import com.arndtt.bookclub.services.BookService;
import com.arndtt.bookclub.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        List<Book> allBooks = bookService.allBooks();
        model.addAttribute("allBooks", allBooks);
        model.addAttribute("user", user);
        return "dashboard.jsp";
    }
    
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
        return "redirect:/books";
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
        return "redirect:/books";
    }

    // --------------- Logout ---------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uuid");
        return "redirect:/";
    }

}
