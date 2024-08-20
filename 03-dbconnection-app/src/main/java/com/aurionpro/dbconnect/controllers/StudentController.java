package com.aurionpro.dbconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	
	@GetMapping("students")
	public List<Student> getAllStudent(){
		return repository.getAllStudent();
	}
}
