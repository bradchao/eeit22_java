package com.example.spring4.dto;

import java.util.Date;

public record OrderDto(
		Integer orderId,
		Date orderDate
		) {}
