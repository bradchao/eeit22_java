package com.example.spring1.apis;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.utils.User;

@RestController
@RequestMapping("/brad04")
public class Brad04 {

	@RequestMapping("/calc")
	public String calc(
			@RequestParam(required = false, defaultValue = "0") String x, 
			@RequestParam(required = false, defaultValue = "0") String y) {

		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			int intR = intX + intY;
			return intR + "";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping("/test1")
	public void test1(@RequestBody User user) {
		System.out.println("debug");
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getGender());
	}
	
}
