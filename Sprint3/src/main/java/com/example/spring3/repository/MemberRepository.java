package com.example.spring3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring3.entity.Member;

@Repository
public interface MemberRepository extends  JpaRepository<Member, Long>{
	boolean existsByAccount(String account);
}
