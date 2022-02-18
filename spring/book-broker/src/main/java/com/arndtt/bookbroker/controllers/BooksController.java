package com.arndtt.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.arndtt.bookbroker.models.Book;
import com.arndtt.bookbroker.models.LoginUser;
import com.arndtt.bookbroker.models.User;
import com.arndtt.bookbroker.services.BookService;
import com.arndtt.bookbroker.services.UserService;

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
import org.springframework.web.bind.annotation.RequestParam;

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
        book.setCreator(user);
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
        if(session.getAttribute("uuid") != (book.getCreator().getId())) {
            User user = userService.oneUser((Long) session.getAttribute("uuid"));
            List<Book> allBooks = bookService.availableBooks();
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
        BindingResult result, Model model, HttpSession session) {
        
        if(session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        if(result.hasErrors()) {
            return "bookEditForm.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        book.setCreator(user);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // --------------- Check Book Out -----------------
    @PutMapping("/books/checkout")
    public String bookCheckOut(@RequestParam("bookId") Long bookId, Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        Book book = bookService.oneBook(bookId);
        if(book.getBorrower() != null) {
            User user = userService.oneUser((Long) session.getAttribute("uuid"));
            List<Book> allBooks = bookService.availableBooks();
            model.addAttribute("allBooks", allBooks);
            model.addAttribute("user", user);
            return "dashboard.jsp";
        }
        User borrower = userService.oneUser((Long) session.getAttribute("uuid"));
        book.setBorrower(borrower);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // --------------- Return Book ---------------
    @PutMapping("/books/return")
    public String bookReturn(@RequestParam("bookId") Long bookId, Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        Book book = bookService.oneBook(bookId);
        User user = userService.oneUser((Long) session.getAttribute("uuid"));
        if(book.getBorrower() != user) {
            List<Book> allBooks = bookService.availableBooks();
            model.addAttribute("allBooks", allBooks);
            model.addAttribute("user", user);
            return "dashboard.jsp";
        }
        book.setBorrower(null);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // --------------- Delete Book ---------------
    @DeleteMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, Model model, HttpSession session) {
        if(session.getAttribute("uuid") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "login.jsp";
        }
        Book book = bookService.oneBook(id);
        if(session.getAttribute("uuid") != (book.getCreator().getId())) {
            return "redirect:/books";
        }
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
