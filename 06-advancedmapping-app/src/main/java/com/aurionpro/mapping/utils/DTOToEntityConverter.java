package com.aurionpro.mapping.utils;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.dto.InstructorDto;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Instructor;
import com.aurionpro.mapping.entity.Student;

public class DTOToEntityConverter {

	public static Instructor convertTOInstructorEntity(InstructorDto instructorDto) {
		return new Instructor(
				instructorDto.getInstructorId(),
				instructorDto.getName(),
				instructorDto.getEmail(),
				instructorDto.getQualification(),
				null
				);
		}

	public static Course convertToCourseEntity(Coursedto coursedto) {
		 Course course = new Course();
	        course.setCourseId(coursedto.getCourseId());
	        course.setCourseName(coursedto.getCourseName());
	        course.setDuration(coursedto.getDuration());
	        course.setFees(coursedto.getFees());
	        return course;
	}

	public static Student convetToStudetntEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setRollno(studentDto.getRollno());
		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		student.setAge(studentDto.getAge());
		return student;
	}
}
