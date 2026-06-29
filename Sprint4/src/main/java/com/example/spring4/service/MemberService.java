package com.example.spring4.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring4.entity.Info;
import com.example.spring4.entity.Member;
import com.example.spring4.repo.InfoRepo;
import com.example.spring4.repo.MemberRepo;

public class MemberService {
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private InfoRepo infoRepo;
	
	@Transactional
	public Member save(Member member, Info info) {
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		member.setInfo(info);
		return memberRepo.save(member);
	}

	public void setInfo2Member(Info info, Long id) {
		
	}
	
	
}
