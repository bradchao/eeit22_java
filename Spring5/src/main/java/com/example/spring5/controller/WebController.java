package com.example.spring5.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring5.apis.User;

/*
 * request => Controller
 * 				-> Model (網頁所需要的資料)
 * 				-> View(Resolver) Thymeleaf -> HTML content
 * 				-> Response 
 * request => RestController
 * 				-> service
 * 				-> return String(頁面原始碼) or  ResponseEntity.ok(物件)
 */
@Controller
@RequestMapping("/")
public class WebController {

	/*
	 * ThymeleafViewResolver: prefix + viewName + suffix
	 * 預設值
	 * prefix: spring.thymeleaf.prefix=classpath:/templates/
	 * suffix: spring.thymeleaf.suffix=.html
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/member")
	public String memberIndex() {
		return "/member/index";
	}
	
	@RequestMapping("/page1")
	public String page1(Model model) {
		model.addAttribute("companyName", "Brad Big Company");
		model.addAttribute("userName", "Brad");
		
		User user = new User();
		user.setName("Kevin");
		user.setGender(true);
		user.setAge(18);
		
		model.addAttribute("user", user);
		
		String now = LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		model.addAttribute("now", now);
		
		return "page1";
	}
	
	@RequestMapping("/page2/{status}")
	public String page2(Model model, @PathVariable String status) {
		model.addAttribute("status", status);
		return "page2";
	}
	
	
}
