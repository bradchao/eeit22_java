package com.example.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring3.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
}
