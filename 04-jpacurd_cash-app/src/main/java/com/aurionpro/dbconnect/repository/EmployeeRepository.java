package com.aurionpro.dbconnect.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.dbconnect.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Page<Employee> findByFirstName(String companyName, Pageable pageable);
}
