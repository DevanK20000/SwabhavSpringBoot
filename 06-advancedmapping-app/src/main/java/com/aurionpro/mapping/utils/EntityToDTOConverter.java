package com.aurionpro.mapping.utils;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.dto.InstructorDto;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Instructor;
import com.aurionpro.mapping.entity.Student;

public class EntityToDTOConverter {

	public static InstructorDto convertToInstructorDTO(Instructor instructor) {
		return new InstructorDto(
				instructor.getInstructorId(),
				instructor.getName(),
				instructor.getEmail(),
				instructor.getQualification()
				);
	}

	public static Coursedto convertToCourseDTO(Course course) {
		 Coursedto coursedto = new Coursedto();
	        coursedto.setCourseId(course.getCourseId());
	        coursedto.setCourseName(course.getCourseName());
	        coursedto.setDuration(course.getDuration());
	        coursedto.setFees(course.getFees());
	        return coursedto;
	}

	public static StudentDto convertToStudentDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setRollno(student.getRollno());
		studentDto.setName(student.getName());
		studentDto.setEmail(student.getEmail());
		studentDto.setAge(student.getAge());
		return studentDto;
	}
}
