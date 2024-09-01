package com.aurionpro.dbconnect.service;

import java.util.List;

import com.aurionpro.dbconnect.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student getStudent(Integer rollno);
	void addStudent(Student student);
	List<Student> getSudentsByName(String name);
}
