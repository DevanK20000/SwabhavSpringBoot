package com.aurionpro.dbconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.exceptions.EmployeeNotFoundException;
import com.aurionpro.dbconnect.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public PageRespose<Employee> getAllEmployees(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> studentPage =repository.findAll(pageable);
		PageRespose<Employee> pageRespose = new PageRespose<Employee>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
	}

	@Override
	public PageRespose<Employee> getAllEmployeesByFirstName(String firstName, int pageNo, int pageSize) {
		// TODO Auto-generated method 
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> studentPage =repository.findByFirstName(firstName, pageable);
		PageRespose<Employee> pageRespose = new PageRespose<Employee>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
		
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		repository.save(employee);

	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = repository.findById(employeeId);
		if(!employee.isPresent())
			throw new EmployeeNotFoundException();
		return employee.get();
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
