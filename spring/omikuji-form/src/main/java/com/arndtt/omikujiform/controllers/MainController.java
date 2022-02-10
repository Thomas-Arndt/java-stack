package com.arndtt.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/omikuji")
	public String omikujiForm() {
		return "omikuji-form.jsp";
	}
	
	@PostMapping("/form/process")
	public String processForm(
			HttpSession session, 
			@RequestParam(value="numberChoice") String numberChoice,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="occupation") String occupation,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="message") String message) {
		
		session.setAttribute("numberChoice", numberChoice);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("occupation", occupation);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		model.addAttribute("numberChoice", session.getAttribute("numberChoice"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("occupation", session.getAttribute("occupation"));
		model.addAttribute("thing", session.getAttribute("thing"));
		model.addAttribute("message", session.getAttribute("message"));
		
		return "omikuji-display.jsp";
	}
}
