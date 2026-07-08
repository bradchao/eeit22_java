package com.example.spring11.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring11.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Long>{

}
