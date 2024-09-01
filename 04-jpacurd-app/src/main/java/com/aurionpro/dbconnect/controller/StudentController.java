package com.aurionpro.dbconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.service.StudentServiceImpl;

@RestController
@RequestMapping("/studentapp")
public class StudentController{
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("student")
	public ResponseEntity<PageRespose<Student>> getAllStudents(@RequestParam(required = false) String name,@RequestParam int pageNo, @RequestParam int pageSize) {
		if(name!=null) {
			return ResponseEntity.ok(studentServiceImpl.getAllStudentsByName(name,pageNo,pageSize));
		}
		return ResponseEntity.ok(studentServiceImpl.getAllStudents(pageNo,pageSize));
	}
	
	
	@GetMapping("student/{rollno}")
	public Student getStudentById(@PathVariable int rollno) {
		return studentServiceImpl.getStudetById(rollno);
	}
	
	@PostMapping("student")
	public String addStudent(@RequestBody Student student) {
		//TODO: process POST request
		studentServiceImpl.addSudent(student);
		return "added";
	}
	
	
	@PutMapping("student")
	public String updateStudent( @RequestBody Student student) {
		//TODO: process PUT request
		studentServiceImpl.updateStudent(student);
		return "Updated";
	}
	
	@DeleteMapping("student/{rollno}")
	public String deleteStudent(@PathVariable int rollno) {
		studentServiceImpl.deleteStudent(rollno);
		return "deleted";
	}
	
}
