package com.example.spring4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring4.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	List<Employee> searchByTitleStartingWith(String start);
}
