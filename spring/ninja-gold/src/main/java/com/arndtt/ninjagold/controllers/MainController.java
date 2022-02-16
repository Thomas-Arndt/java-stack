package com.arndtt.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private Random randomGenerator = new Random();
	private boolean bankrupt = false;

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		
		if(session.getAttribute("activity")==null) {
			session.setAttribute("activity", new ArrayList<String>());
		}
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		
//		model.addAttribute("gold", session.getAttribute("gold"));
//		model.addAttribute("activity", session.getAttribute("activity"));
		
		return bankrupt ? "debtPrison.jsp" : "index.jsp";
	}
	
	@PostMapping("/find/gold")
	public String findGold(
			HttpSession session,
			@RequestParam(value="propertyType") String propertyType) {
		System.out.println(propertyType);
		if(propertyType.equals("farm")) {
			Integer newGold = randomGenerator.nextInt(11)+10;
			Integer gold = (Integer) session.getAttribute("gold")+ newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "You received "+newGold+" gold from the farm. ("+new Date()+")");
			session.setAttribute("activity", activity);
		}
		if(propertyType.equals("cave")) {
			Integer newGold = randomGenerator.nextInt(6)+5;
			Integer gold = (Integer) session.getAttribute("gold")+ newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "You received "+newGold+" gold from the cave. ("+new Date()+")");
			session.setAttribute("activity", activity);
		}
		if(propertyType.equals("house")) {
			Integer newGold = randomGenerator.nextInt(5)+2;
			Integer gold = (Integer) session.getAttribute("gold")+ newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "You received "+newGold+" gold from the house. ("+new Date()+")");
			session.setAttribute("activity", activity);
		}
		if(propertyType.equals("casino")) {
			String changeSign;
			Integer newGold = randomGenerator.nextInt(50)+1;
			if(randomGenerator.nextBoolean()){
				newGold = newGold*-1;
			}
			Integer gold = (Integer) session.getAttribute("gold")+ newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			if(newGold >= 0) {
				changeSign = "received";
			} else {
				changeSign = "lost";
			}
			activity.add(0, "You "+changeSign+" "+Math.abs(newGold)+" gold from the casino. ("+new Date()+")");
			session.setAttribute("activity", activity);
		}
		if(propertyType.equals("spa")) {
			Integer newGold = randomGenerator.nextInt(16)+5;
			Integer gold = (Integer) session.getAttribute("gold")- newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "You spent "+newGold+" gold at the spa. ("+new Date()+")");
			session.setAttribute("activity", activity);
		}
		if(propertyType.equals("reset")) {
			session.setAttribute("gold", 0);
			session.setAttribute("activity", new ArrayList<String>());
			bankrupt = false;
		}
		if((Integer) session.getAttribute("gold") <= -150) {
			bankrupt = true;
		}
		return "redirect:/";
	}
}
