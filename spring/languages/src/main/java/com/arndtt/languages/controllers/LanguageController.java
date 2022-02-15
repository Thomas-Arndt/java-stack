package com.arndtt.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.arndtt.languages.models.Language;
import com.arndtt.languages.services.LanguageService;

@Controller
public class LanguageController {
	private LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService=languageService;
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> allLanguages = languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			List<Language> allLanguages = languageService.allLanguages();
			model.addAttribute("allLanguages", allLanguages);
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String displayOne(@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "language.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			System.out.println(language.getId());
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
