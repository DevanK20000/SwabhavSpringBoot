package com.aurionpro.dbconnect.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.dto.PageRespose;
import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repositiory.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public PageRespose<Student> getAllStudents(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> studentPage =repository.findAll(pageable);
		PageRespose<Student> pageRespose = new PageRespose<Student>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
	}

	@Override
	public void addSudent(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);
	}

	@Override
	public Student getStudetById(Integer rollno) {
		// TODO Auto-generated method stub 
		return repository.findById(rollno).get();
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);
	}

	@Override
	public void deleteStudent(Integer rollno) {
		// TODO Auto-generated method stub
		repository.deleteById(rollno);
	}

	@Override
	public PageRespose<Student> getAllStudentsByName(String name,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> studentPage =repository.findByName(name, pageable);
		PageRespose<Student> pageRespose = new PageRespose<Student>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());
		pageRespose.setContent(studentPage.getContent());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
	}

	
}
