package com.example.spring9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {

	@RequestMapping("/test1")
	public String test1() {
		return "test1";
	}
}
