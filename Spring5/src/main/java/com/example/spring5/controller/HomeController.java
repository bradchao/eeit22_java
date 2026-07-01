package com.example.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring5.repo.HotelRepo;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HotelRepo hotelRepo;
	
	@GetMapping("")
	public String home() {
		return "home";
	}
	
	
	
	
}
