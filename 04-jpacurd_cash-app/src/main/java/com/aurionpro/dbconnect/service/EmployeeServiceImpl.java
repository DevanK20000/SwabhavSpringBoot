package com.aurionpro.dbconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Page<Employee> getAllEmployees(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repository.findAll(pageable);
	}

	@Override
	public Page<Employee> getAllEmployeesByFirstName(String firstName, int pageNo, int pageSize) {
		// TODO Auto-generated method 
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repository.findByFirstName(firstName, pageable);	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		repository.save(employee);

	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return repository.findById(employeeId).get();
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		repository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		repository.deleteById(employeeId);
	}

}
