package com.aurionpro.mapping.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.mapping.dto.EmployeeResponse;
import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.entity.Employee;
import com.aurionpro.mapping.entity.SalaryAccount;
import com.aurionpro.mapping.exceptions.EmployeeNotFoundException;
import com.aurionpro.mapping.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public PageRespose<EmployeeResponse> getAllEmployees(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> employeePage = repository.findAll(pageable);
		PageRespose<EmployeeResponse> pageRespose = new PageRespose<>();
		pageRespose.setToatalPage(employeePage.getTotalPages());
		pageRespose.setSize(employeePage.getSize());
		pageRespose.setTotalElements(employeePage.getTotalElements());

		pageRespose.setContent(employeePage.stream()
				.map(emp -> new EmployeeResponse(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(),
						emp.getPhoneNumber(), emp.getEmail(), emp.getPosition(), emp.getHireDate(), emp.getSalary(),
						emp.getBankIfscNumber(), emp.getEmployeeStatus()))
				.collect(Collectors.toList()));

		pageRespose.setLastPage(employeePage.isLast());
		return pageRespose;
	}

	@Override
	public PageRespose<EmployeeResponse> getAllEmployeesByFirstName(String firstName, int pageNo, int pageSize) {
		// TODO Auto-generated method
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> employeePage = repository.findByFirstName(firstName, pageable);
		PageRespose<EmployeeResponse> pageRespose = new PageRespose<>();
		pageRespose.setToatalPage(employeePage.getTotalPages());
		pageRespose.setSize(employeePage.getSize());
		pageRespose.setTotalElements(employeePage.getTotalElements());

		pageRespose.setContent(employeePage.stream()
				.map(emp -> new EmployeeResponse(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(),
						emp.getPhoneNumber(), emp.getEmail(), emp.getPosition(), emp.getHireDate(), emp.getSalary(),
						emp.getBankIfscNumber(), emp.getEmployeeStatus()))
				.collect(Collectors.toList()));
		pageRespose.setLastPage(employeePage.isLast());
		return pageRespose;

	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		repository.save(employee);

	}

	@Override
	public EmployeeResponse getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOpt = repository.findById(employeeId);
		if (!employeeOpt.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		Employee employee = employeeOpt.get();

		return new EmployeeResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
				employee.getPhoneNumber(), employee.getEmail(), employee.getPosition(), employee.getHireDate(),
				employee.getSalary(), employee.getBankIfscNumber(), employee.getEmployeeStatus());
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

	@Override
	public Employee updateEmployeeSalaryAccount(int employeeId, SalaryAccount salaryAccount) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOpt = repository.findById(employeeId);
		if (!employeeOpt.isPresent()) {
			throw new EmployeeNotFoundException();
		}
		Employee dbEmployee = employeeOpt.get();
		SalaryAccount dbSalaryAccount = dbEmployee.getSalaryAccount();

		if(!(salaryAccount.getAccountNumber()==null)) {
			dbSalaryAccount.setAccountNumber(salaryAccount.getAccountNumber());
		}
		if(!(salaryAccount.getAccountNumber()==null)) {
			dbSalaryAccount.setAccountHolderName(salaryAccount.getAccountHolderName());
		}

		dbEmployee.setSalaryAccount(dbSalaryAccount);
		return repository.save(dbEmployee);
	}

}
