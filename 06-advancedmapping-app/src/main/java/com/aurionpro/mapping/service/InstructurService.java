package com.aurionpro.mapping.service;

import java.util.List;
import java.util.Set;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.dto.InstructorDto;
import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Instructor;

public interface InstructurService {
	InstructorDto addInstructor(InstructorDto instructorDto);

	InstructorDto getInstructor(int instructorId);

	List<Coursedto> getInstructorsCourse(int instructorId);

	PageRespose<InstructorDto> getAllInstructors(int pageNumnber, int pageSize);


	Instructor allocateCourses(int id, List<Integer> courseIds);

	Set<StudentDto> getInstructorsStudent(int id);
}
