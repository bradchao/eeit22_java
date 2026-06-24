package com.example.spring3.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring3.entity.Member;
import com.example.spring3.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberService service;
	/*
	 * request: account=?
	 * response: true/false
	 */
	@GetMapping("/exist")
	public ResponseEntity<Boolean> checkAccount(@RequestParam String account) {
		boolean isExist = service.checkAccount(account);
		// System.out.println(isExist);
		return ResponseEntity.ok(isExist);
	}
	
	/*
	 * request: Member
	 * response: {"success": true/false}
	 */
	@PostMapping("/register")
	public ResponseEntity<Map<String,Boolean>> register(@RequestBody Member member) {
		System.out.println(member.getAccount() + ":" + member.getPasswd());
		boolean isSuccess = service.register(member);
		
		Map<String,Boolean> map = Map.of("success", isSuccess);
		return ResponseEntity.ok(map);
	}
	
}
