package com.example.spring8.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JwtAspect {

	@Around("@annotation(com.example.spring8.annotation.CheckJwt)")
	public Object checkJwt() throws Throwable {
		
		return null;
	}
	
}
