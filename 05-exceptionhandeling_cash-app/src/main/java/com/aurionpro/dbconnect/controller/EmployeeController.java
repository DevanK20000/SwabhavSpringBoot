package com.aurionpro.dbconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("employeeapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employee")
	public ResponseEntity<PageRespose<Employee>> getAllEmployees(@RequestParam(required = false) String firstName, @RequestParam int pageNo, @RequestParam int pageSize) {
	    if (firstName != null) {
	        return ResponseEntity.ok(employeeService.getAllEmployeesByFirstName(firstName, pageNo, pageSize));
	    }
	    return ResponseEntity.ok(employeeService.getAllEmployees(pageNo, pageSize));
	}

	@GetMapping("employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
	    return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping("employee")
	public String addEmployee(@Valid @RequestBody Employee employee) {
	    // TODO: process POST request
	    employeeService.addEmployee(employee);
	    return "added";
	}

	@PutMapping("employee")
	public String updateEmployee(@RequestBody Employee employee) {
	    // TODO: process PUT request
	    employeeService.updateEmployee(employee);
	    return "Updated";
	}

	@DeleteMapping("employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
	    employeeService.deleteEmployee(employeeId);
	    return "deleted";
	}

}
