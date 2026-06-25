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
import com.example.spring3.repository.MemberRepository;
import com.example.spring3.service.MemberService;

import jakarta.servlet.http.HttpSession;

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
	
	/*
	 * request: {account:xxx, passwd: xxx}
	 * response: {"success": true/false}
	 */
	@PostMapping("/login")
	public ResponseEntity<Map<String,Boolean>> login(
			@RequestBody Map<String,String> body){
		String account = body.get("account");
		String passwd = body.get("passwd");
		
		//boolean isSuccess = service.login(account, passwd);
		boolean isSuccess = service.loginV2(account, passwd);
		
		Map<String,Boolean> map = Map.of("success", isSuccess);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/loginV2")
	public ResponseEntity<Map<String,Boolean>> login(
			@RequestBody Map<String,String> body,
			HttpSession session
			){
		String account = body.get("account");
		String passwd = body.get("passwd");
		
		Member member = service.loginV3(account, passwd);
		
		Map<String,Boolean> map;
		if (member != null) {
			session.setAttribute("member", member);
			map = Map.of("success", true);
		}else {
			session.invalidate();
			map = Map.of("success", false);
		}
		
		return ResponseEntity.ok(map);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<Map<String,Boolean>> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok(Map.of("success", true));
	}
	
	
	
}
