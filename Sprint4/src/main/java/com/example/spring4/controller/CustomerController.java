package com.example.spring4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring4.dto.CustomerDto;
import com.example.spring4.dto.OrderDetailDto;
import com.example.spring4.dto.OrderDto;
import com.example.spring4.entity.Customer;
import com.example.spring4.entity.Order;
import com.example.spring4.entity.OrderDetail;
import com.example.spring4.repo.CustomerRepo;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	//private MemberController memberController;
	
	@Autowired
	private CustomerRepo repo;
	
	//public CustomerController() {memberController = new MemberController();}
	@GetMapping("/v1/{id}")
	public ResponseEntity<Customer> test1(@PathVariable String id){
		return ResponseEntity.ok(repo.findById(id).orElse(null));
	}
	
	@GetMapping("/v2/{id}")
	public ResponseEntity<Customer> test2(@PathVariable String id){
		Optional<Customer> opt = repo.findById(id);
		if (opt.isPresent()) {
			Customer customer = opt.get();
		}
		
		//repo.findByCustomerID(id).orElse(new Customer());
		//repo.findByCustomerID(id).orElseGet(Customer::new);
		
		return ResponseEntity.ok(
				repo.findByCustomerID(id).orElseThrow(() -> new IllegalArgumentException("ID ERROR")));
		
	}
	
	@GetMapping("/v3/{id}")
	public ResponseEntity<CustomerDto> test3(@PathVariable String id){
		Customer c = repo.findById(id).orElse(null);
		List<Order> orders =  c.getOrders();
		
		ArrayList<OrderDto> orderList = new ArrayList<OrderDto>();
		for (Order order : orders) {
			List<OrderDetail> details = order.getOrderDetails();
			
			ArrayList<OrderDetailDto> detailDtos = new ArrayList<OrderDetailDto>();
			for (OrderDetail detail : details) {
				detailDtos.add(
					new OrderDetailDto(
							detail.getUnitPrice(), 
							detail.getQuantity(), 
							detail.getProduct().getProductName()));
			}
			orderList.add(new OrderDto(order.getOrderid(), order.getOrderdate(), detailDtos));
		}
		
		CustomerDto cDto = new CustomerDto(
				c.getCustomerid(), c.getCompanyName(), orderList);
		
		
		return ResponseEntity.ok(cDto);
	}	
	
}
