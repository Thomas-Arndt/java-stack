package com.arndtt.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arndtt.fruityloops.Item;

@Controller
public class FruityLoopsController {
		
	@RequestMapping("/")
	public String index(Model model) {
		
		ArrayList<Item> allFruit = new ArrayList<Item>();
		allFruit.add(new Item("Kiwi", 1.5));
		allFruit.add(new Item("Mango", 2.0));
		allFruit.add(new Item("Tomato", 1.75));
		allFruit.add(new Item("Guava", 0.75));
		
		model.addAttribute("allFruit", allFruit);
		
		return "index.jsp";
	}
}
