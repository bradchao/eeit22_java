package com.example.spring3.dto;

import lombok.Data;

@Data
public class Base64Upload {
	private String fileName;
	private String contentType;
	private String base64;
}
