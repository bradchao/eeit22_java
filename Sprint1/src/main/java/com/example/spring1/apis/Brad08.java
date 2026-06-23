package com.example.spring1.apis;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.utils.Member;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
public class Brad08 {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@PostMapping("")
	public void addMember(@RequestBody @Valid Member member) {
		String sql = """
				INSERT INTO member
					(account, passwd)
				VALUES
					(:account, :passwd)
				""";	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", member.getAccount());
		map.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		
		int n = jdbc.update(sql, map);
		System.out.println(n);
		
	}
	
	
}
