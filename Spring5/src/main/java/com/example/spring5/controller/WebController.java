package com.example.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "page1";
	}
	
	
}
