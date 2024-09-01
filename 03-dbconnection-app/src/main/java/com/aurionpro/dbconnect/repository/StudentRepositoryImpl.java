package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> getAllStudent() {
		
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s",Student.class);
		return query.getResultList();
	}

	@Override
	public Student getSudent(Integer rollno) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, rollno);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
	}

	@Override
	public List<Student> getStudentByName(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.name=:theName",Student.class);
		query.setParameter("theName", name);
		return query.getResultList();
	}

}
