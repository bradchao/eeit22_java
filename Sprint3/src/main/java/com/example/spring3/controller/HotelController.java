package com.example.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring3.repository.HotelRepository;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	private HotelRepository repository;

	@GetMapping("")
	public void queryHotelByPage(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int rpp) {
		
		
		
		
		
	}
	
	
}
