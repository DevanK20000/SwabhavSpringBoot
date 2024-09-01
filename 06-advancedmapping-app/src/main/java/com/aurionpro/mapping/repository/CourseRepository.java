package com.aurionpro.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Instructor;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	List<Course> findByInstructor(Instructor instructor);

}
