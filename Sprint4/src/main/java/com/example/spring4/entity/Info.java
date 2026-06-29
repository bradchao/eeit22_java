package com.example.spring4.entity;

import org.hibernate.validator.constraints.CodePointLength;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "memberinfo")
public class Info {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tel, birthday;
	
	@Column(name = "gender")
	private Boolean isMale;
	
	//-----------------------
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Member member;
	
	
}
