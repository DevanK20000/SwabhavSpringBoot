package com.aurionpro.dbconnect.service;

import org.springframework.data.domain.Page;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Student;

public interface StudentService {
	PageRespose<Student> getAllStudents(int pageNo, int pageSize);

	PageRespose<Student> getAllStudentsByName(String name, int pageNo, int pageSize);

	void addSudent(Student student);

	Student getStudetById(Integer rollno);

	void updateStudent(Student student);

	void deleteStudent(Integer rollno);

}
