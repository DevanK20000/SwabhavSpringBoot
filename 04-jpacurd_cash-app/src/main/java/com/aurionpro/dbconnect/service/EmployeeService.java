package com.aurionpro.dbconnect.service;

import org.springframework.data.domain.Page;

import com.aurionpro.dbconnect.entity.Employee;

public interface EmployeeService {
	Page<Employee> getAllEmployees(int pageNo, int pageSize);

	Page<Employee> getAllEmployeesByFirstName(String firstName, int pageNo, int pageSize);

	void addEmployee(Employee employee);

	Employee getEmployeeById(Integer employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployee(Integer employeeId);
}
