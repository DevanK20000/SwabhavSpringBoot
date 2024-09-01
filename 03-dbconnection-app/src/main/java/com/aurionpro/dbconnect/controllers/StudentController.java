package com.aurionpro.dbconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.entity.Employee;
import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repository.StudentRepository;
import com.aurionpro.dbconnect.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/studentsapp")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("students/{rollno}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer rollno) {
		return ResponseEntity.ok(studentService.getStudent(rollno));
	}
	
	@PostMapping("students")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added";
	}
	
	@GetMapping("students/name")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
		return ResponseEntity.ok(studentService.getSudentsByName(name));
	}
	
}
