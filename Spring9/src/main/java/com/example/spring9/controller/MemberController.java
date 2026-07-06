package com.example.spring9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MemberController {
	
	@GetMapping("/login")
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		Model model) {
		
		if (error != null) model.addAttribute("error", "Login Failure");
		if (logout != null) model.addAttribute("logout", "Logout Success");
		
		return "login";
	}

	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("title", "Brad Big Company");
		return "main";
	}
	
}
