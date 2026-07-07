package com.example.spring10.apis;

import lombok.Data;

@Data
public class Customer implements Discountable {
	private int vipLevel;
	
	public Customer(int viplevel) {
		this.vipLevel = viplevel;
	}
	
	@Override
	public int getVipLevel() {
		return vipLevel;
	}
}
