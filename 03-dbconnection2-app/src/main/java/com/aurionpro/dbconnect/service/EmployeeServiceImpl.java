package com.aurionpro.dbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.repository.EmployeeRepository;
import com.aurionpro.dbconnect.repository.EmployeeRepositoryImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositoryImpl employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployee();
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.addEmployee(employee);
	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployee(id);
	}
	
	
}
