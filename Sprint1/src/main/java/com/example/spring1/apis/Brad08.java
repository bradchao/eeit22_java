package com.example.spring1.apis;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.dto.MemberResponse;
import com.example.spring1.utils.Member;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
public class Brad08 {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private MemberResponse memberResponse;
	
	@PostMapping( value = {"", "/{isGetId}"})
	public MemberResponse addMember(@RequestBody @Valid Member member,
			@PathVariable(required = false) Boolean isGetId) {
		String sql = """
				INSERT INTO member
					(account, passwd)
				VALUES
					(:account, :passwd)
				""";	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", member.getAccount());
		map.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		
		//------------------------------
		//int n = jdbc.update(sql, map);
		//System.out.println(n);
		//------------------------------
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int n = jdbc.update(sql, new MapSqlParameterSource(map), keyHolder);
		System.out.println(n);
		System.out.println(keyHolder.getKey().intValue());
		
		if (isGetId == null) isGetId = false;
		
		if (n > 0 ) {
			if (isGetId) {
				member.setId(keyHolder.getKey().intValue());
			}
			memberResponse.setError(0);
			memberResponse.setMessage("Add Member Success");
			memberResponse.setMember(member);
		}else {
			memberResponse.setError(-1);
			memberResponse.setMessage("Add Member Failure");
		}
		return memberResponse;
	}
	
	
}
