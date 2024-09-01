package com.aurionpro.mapping.controller;

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
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.service.CourseService;


@RestController
@RequestMapping("studentapp")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("course/{id}")
	public ResponseEntity<Coursedto> getCourse(@RequestParam int id) {
		return ResponseEntity.ok(courseService.getCourse(id));
	}
	

	@PostMapping("course")
	public ResponseEntity<Course> addCourse(@RequestBody Coursedto coursedto) {
		//TODO: process POST request
		return ResponseEntity.ok(courseService.addCourse(coursedto));
	}

	@PutMapping("courses/{id}/instructor")
	public ResponseEntity<Course> allocateInstructor(@PathVariable int id,@RequestBody Integer instructorId){
		return ResponseEntity.ok(courseService.allocateCourses(id,instructorId));
	}
}
