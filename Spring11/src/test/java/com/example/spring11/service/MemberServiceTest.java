package com.example.spring11.service;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring11.entity.Member;
import com.example.spring11.repo.MemberRepo;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	@Mock 
	MemberRepo repo;
	
	@InjectMocks
	MemberService service;
	
	@Test	// 
	void register_accountExist_shouldThrow() {
		when(repo.existsByAccount("brad")).thenReturn(true);
		//-----------------------------------------
		assertThrows(
			IllegalArgumentException.class, 
			() -> service.register("brad", "123456", "Brad"));
		//--------------------------------------------
		verify(repo, never()).save(any());
		
	}
	
	
	@Test
	void register_success() {
		when(repo.existsByAccount("brad")).thenReturn(false);
		
		Member saved = new Member();
		saved.setId(123L);
		
		when(repo.save(any(Member.class))).thenReturn(saved);
		
		//------------------------------------------
		Member member = service.register("brad", "123456", "Brad");
		//----------------------------------
		assertEquals(123L, member.getId());
		
		//-----------------------------------
		ArgumentCaptor<Member> captor = ArgumentCaptor.forClass(Member.class);
		
		verify(repo).save(captor.capture());
		/*
		 *  verify(repo).xxx() : repo.xxx() 有呼叫到
		 *  verify(repo, never()).xxx(): repo.xxx() 不會呼叫到
		 *  verify(repo, time(n)).xxx(): repo.xxx() 呼叫到n 次
		 */
		
		
		Member m = captor.getValue();
		
		assertEquals("brad", m.getAccount());
		//assertEquals("123456", m.getPasswd());
		assertEquals("Brad", m.getName());
		
		
		
	}


}
