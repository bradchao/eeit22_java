package com.example.spring6.controller;

import org.aspectj.weaver.BCException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring6.dto.Login;
import com.example.spring6.entity.Member;
import com.example.spring6.repo.MemberRepo;
import com.example.spring6.response.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private MemberRepo memberRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		Member member = memberRepo.findByAccount(login.getAccount()).orElse(null);
		if (member == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("帳號錯誤");
		}
		
		if (!BCrypt.checkpw(login.getPasswd(), member.getPasswd())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密碼錯誤");
		}
		
		String token = "token";
		
		return ResponseEntity.ok(new LoginResponse(token, member.getAccount(), member.getName()));
		
		
	}
	
}
