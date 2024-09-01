package com.aurionpro.mapping.service;

import com.aurionpro.mapping.dto.EmployeeResponse;
import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.entity.Employee;
import com.aurionpro.mapping.entity.SalaryAccount;

public interface EmployeeService {
	PageRespose<EmployeeResponse> getAllEmployees(int pageNo, int pageSize);

	PageRespose<EmployeeResponse> getAllEmployeesByFirstName(String firstName, int pageNo, int pageSize);

	void addEmployee(Employee employee);

	EmployeeResponse getEmployeeById(Integer employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployee(Integer employeeId);

	Employee updateEmployeeSalaryAccount(int employeeId, SalaryAccount salaryAccount);
}
