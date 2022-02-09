package com.arndtt.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello(
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="times", required=false) String times) {
		
		if(firstName != null && lastName != null) {
			String outputString = "Hello, " + firstName + " " + lastName + "! ";
			if(times != null) {
				String output = "";
				for(int i = 0; i < Integer.parseInt(times); i++) {
					output += outputString;
				}
				return output;
			} else {
				return outputString;				
			}
		}
		else if(firstName != null) {
			String outputString = "Hello, " + firstName + "! ";
			if(times != null) {
				String output = "";
				for(int i = 0; i < Integer.parseInt(times); i++) {
					output += outputString;
				}
				return output;
			} else {
				return outputString;				
			}
		} else {	
			String outputString = "Hello Human. ";
			if(times != null) {
				String output = "";
				for(int i = 0; i < Integer.parseInt(times); i++) {
					output += outputString;
				}
				return output;
			} else {
				return outputString;				
			}
			
		}
	}


}
