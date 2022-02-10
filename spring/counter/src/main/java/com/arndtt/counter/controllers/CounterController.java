package com.arndtt.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", (Integer) session.getAttribute("count")+1);
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			model.addAttribute("count", 0);
		} else {
			model.addAttribute("count", session.getAttribute("count"));
		}
		return "counter.jsp";
	}
	
	@GetMapping("/counter/2")
	public String counter2(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		} else {
			session.setAttribute("count", (Integer) session.getAttribute("count")+2);
		}
		return "counter2.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "reset.jsp";
	}
}
