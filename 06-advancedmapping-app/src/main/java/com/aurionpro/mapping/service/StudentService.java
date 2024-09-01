package com.aurionpro.mapping.service;

import java.util.List;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Address;
import com.aurionpro.mapping.entity.Student;

public interface StudentService {
	StudentDto addStudent(Student student);
	PageRespose<StudentDto> getAllStudents(int pageNo, int pageSize);
	StudentDto getStudent(int rollno);
	Address getStudentAddress(int rollno);
	Student updateAddress(int rollno, Address address);
	String sendStudentViaEmail(String toEmail);
	List<StudentDto> getAllStudentsList();
	StudentDto assignCourses(int rollno, List<Integer> courseIds);
}
