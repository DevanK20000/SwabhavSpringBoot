package com.aurionpro.mapping.controller;

import java.util.List;
import java.util.Set;

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

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.dto.InstructorDto;
import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Instructor;
import com.aurionpro.mapping.service.InstructurService;


@RestController
@RequestMapping("studentapp")
public class InstructorController {
	@Autowired
	private InstructurService instructurService;

	@PostMapping("instructor")
	public ResponseEntity<InstructorDto> addInstructor(@RequestBody InstructorDto instructorDto) {
		//TODO: process POST request
		return ResponseEntity.ok(instructurService.addInstructor(instructorDto));
	}

	@PutMapping("instructor/{id}/courses")
	public ResponseEntity<Instructor> allocateCourses(@PathVariable int id,@RequestBody List<Integer> courseIds){
		return ResponseEntity.ok(instructurService.allocateCourses(id,courseIds));
	}

	@GetMapping("instructor/{id}")
	public ResponseEntity<InstructorDto> getInstructor(@PathVariable int id) {
		return ResponseEntity.ok(instructurService.getInstructor(id));
	}

	@GetMapping("instructor/{id}/courses")
	public ResponseEntity<List<Coursedto>> getInstructorCourses(@PathVariable int id){
		return ResponseEntity.ok(instructurService.getInstructorsCourse(id));
	}

	@GetMapping("instructor")
	public ResponseEntity<PageRespose<InstructorDto>> getAllInstructor(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(instructurService.getAllInstructors(pageNo,pageSize));
	}

	@GetMapping("instructor/{id}/students")
	public ResponseEntity<Set<StudentDto>> getInstructorStudents(@PathVariable int id){
		return ResponseEntity.ok(instructurService.getInstructorsStudent(id));
	}
}