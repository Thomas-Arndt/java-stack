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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    // ---------------- New Book Form --------------- 
    @GetMapping("/books/new")
    public String bookForm(@ModelAttribute("book") Book book, 
        Model model, HttpSession session) {
        
        if (session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        return "bookForm.jsp";
    }

    // --------------- Process Book Form ---------------
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, 
        BindingResult result, Model model, HttpSession session) {
        
        if (session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        if(result.hasErrors()) {
            return "bookForm.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        book.setUser(user);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // --------------- Book Details ---------------
    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
        
        if (session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        Book book = bookService.oneBook(id);
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        model.addAttribute("uuid", user.getId());
        model.addAttribute("book", book);
        return "bookDetails.jsp";
    }

    // --------------- Book Edit Form ---------------
    @GetMapping("/books/{id}/edit")
    public String editForm(@PathVariable("id") Long id,
        Model model, HttpSession session) {
        
        Book book = bookService.oneBook(id);
        if(session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        if(session.getAttribute("uuid") != (book.getUser().getId())) {
            User user = userService.oneUser((Long) session.getAttribute("uuid"));
            List<Book> allBooks = bookService.allBooks();
            model.addAttribute("allBooks", allBooks);
            model.addAttribute("user", user);
            return "dashboard.jsp";
        }
        model.addAttribute("book", book);
        return "bookEditForm.jsp";
    }

    // --------------- Process Book Edit ---------------
    @PutMapping("/books/{id}/edit")
    public String editBook(@Valid @ModelAttribute("book") Book book,
        BindingResult result, HttpSession session) {
        
        if(result.hasErrors()) {
            return "bookEditForm.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        book.setUser(user);
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
