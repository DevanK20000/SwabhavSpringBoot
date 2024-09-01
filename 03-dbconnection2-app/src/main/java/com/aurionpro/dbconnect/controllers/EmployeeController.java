package com.aurionpro.dbconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.service.EmployeeService;

import jakarta.persistence.Entity;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@GetMapping("employees/{id}")	
	public ResponseEntity<Employee> getMethodName(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@PostMapping("employees")
	public String addEmployee(@RequestBody Employee employee) {
		//TODO: process POST request
		employeeService.addEmployee(employee);
		return "Employee Added";
	}
	

	
	
	
}
