package com.aurionpro.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Address;
import com.aurionpro.mapping.entity.Student;
import com.aurionpro.mapping.service.StudentService;

@RestController
@RequestMapping("studentapp")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("student")
	public ResponseEntity<PageRespose<StudentDto>> getAllStudents(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(studentService.getAllStudents(pageNo,pageSize));
	}

	@GetMapping("student/{rollno}")
	public StudentDto getStudent(@PathVariable int rollno) {
		return studentService.getStudent(rollno);
	}

	@PutMapping("student/address/{rollno}")
	public ResponseEntity<Student> updateStudentAddress(@PathVariable int rollno, @RequestBody Address address) {
		//TODO: process PUT request
		Student studentResponse = studentService.updateAddress(rollno, address);
		return ResponseEntity.ok(studentResponse);
	}


	@PostMapping("student")
	public ResponseEntity<StudentDto> addStudent(@RequestBody Student student) {
		//TODO: process POST request
		StudentDto studentResponse = studentService.addStudent(student);
		return ResponseEntity.ok(studentResponse);
	}

	@GetMapping("student/email")
	public ResponseEntity<String> sendStudentEmail(@RequestParam String toEmail) {
		return ResponseEntity.ok(studentService.sendStudentViaEmail(toEmail));
	}

	@PutMapping("student/{rollno}/courses")
	public  ResponseEntity<StudentDto> allocateCourseToStudent(@PathVariable int rollno, @RequestBody List<Integer> courseIds) {
		//TODO: process PUT request

		return ResponseEntity.ok(studentService.assignCourses(rollno, courseIds));
	}
}
