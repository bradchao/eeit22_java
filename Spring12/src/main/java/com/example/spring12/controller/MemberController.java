package com.example.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/locale")
	public String locale() {
		return LocaleContextHolder.getLocale().toString();
	}
	
	@RequestMapping("/test1")
	public void test1() {
		String mesg = messageSource.getMessage("member.login.successOK", 
				null, LocaleContextHolder.getLocale());
		System.out.println(mesg);
	}
	
}
