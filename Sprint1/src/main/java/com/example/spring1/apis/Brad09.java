package com.example.spring1.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.spring1.utils.User;

@RestController
@RequestMapping("/brad09")
public class Brad09 {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private User user;
	
	@RequestMapping("/test1")
	public void test1() {
		String url = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		String json = restTemplate.getForObject(url, String.class);
		System.out.println(json);
		
		
		
	}
	
	
}
