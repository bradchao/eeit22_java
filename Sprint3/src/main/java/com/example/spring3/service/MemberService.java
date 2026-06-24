package com.example.spring3.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring3.entity.Member;
import com.example.spring3.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
	public boolean checkAccount(String account) {
		return repository.existsByAccount(account);
	}
	
	public boolean register(Member member) {
		if (checkAccount(member.getAccount())) return false;
		
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));

		Member m = repository.save(member);
		System.out.println(m.getId() +":" + m.getPasswd());
		return m!= null;
	}
	
}
