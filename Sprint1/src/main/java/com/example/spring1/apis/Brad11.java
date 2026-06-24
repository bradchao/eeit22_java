package com.example.spring1.apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/north")
public class Brad11 {

	@Autowired
	@Qualifier("northJdbc")
	private NamedParameterJdbcTemplate jdbc;
	
	@GetMapping("/test1")
	public void test1() {
		String sql = """
				SELECT EmployeeID, LastName,FirstName, Title
				FROM employees
				""";
		List<Map<String,Object>> emplyees = jdbc.queryForList(sql, new HashMap<>());
		System.out.println(emplyees.size());
	}
	
	@GetMapping(value = {"/orders", "/orders/{orderId}"})
	public List<Order> test2() {
		
	}
	
}
