package com.aurionpro.dbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repository.StudentRepositoryImpl;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepositoryImpl studentRepos;
	
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepos.getAllStudent();
	}


	@Override
	public Student getStudent(Integer rollno) {
		// TODO Auto-generated method stub
		return studentRepos.getSudent(rollno);
	}


	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepos.addStudent(student);
	}


	@Override
	public List<Student> getSudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepos.getStudentByName(name);
	}

}
