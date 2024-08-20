package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> getAllStudent() {
		
		TypedQuery<Student> query =entityManager.createQuery("select s from Student s",Student.class);
		return query.getResultList();
	}

}
