package com.aurionpro.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.dto.InstructorDto;
import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Instructor;
import com.aurionpro.mapping.repository.CourseRepository;
import com.aurionpro.mapping.repository.InstructorRepository;
import com.aurionpro.mapping.utils.DTOToEntityConverter;
import com.aurionpro.mapping.utils.EntityToDTOConverter;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructorServiceImpl implements InstructurService{

	@Autowired
	InstructorRepository instructorRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public InstructorDto addInstructor(InstructorDto instructorDto) {
		// TODO Auto-generated method stub
		Instructor instructor =  DTOToEntityConverter.convertTOInstructorEntity(instructorDto);
		return EntityToDTOConverter.convertToInstructorDTO(instructorRepository.save(instructor));
	}

	@Override
	public Instructor allocateCourses(int id, List<Integer> courseIds) {
		// TODO Auto-generated method stub
		Optional<Instructor> instructorOptional = instructorRepository.findById(id);
		if(!instructorOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		Instructor instructor = instructorOptional.get();

		List<Course> courses = new ArrayList<>();
		courseIds.forEach(courseId ->{
			Optional<Course> courseOptional = courseRepository.findById(courseId);
			if(!courseOptional.isPresent()) {
				throw new EntityNotFoundException();
			}

			Course course = courseOptional.get();
			course.setInstructor(instructor);
			courses.add(course);
		});
		instructor.setCourses(courses);
		return instructorRepository.save(instructor);
	}

	@Override
	public InstructorDto getInstructor(int instructorId) {
		// TODO Auto-generated method stub
		Optional<Instructor> instructorOptional =  instructorRepository.findById(instructorId);
		if(!instructorOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		return EntityToDTOConverter.convertToInstructorDTO(instructorOptional.get());
	}

	@Override
	public List<Coursedto> getInstructorsCourse(int instructorId) {
		// TODO Auto-generated method stub
//		Optional<Instructor> instructorOptional =  instructorRepository.findById(instructorId);
//		if(!instructorOptional.isPresent())
//			return null;
//		return instructorOptional.get().getCourses().stream().map(EntityToDTOConverter::convertToCourseDTO).collect(Collectors.toList());
		Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
		if(!instructorOptional.isPresent()) {
			throw new EntityNotFoundException();
		}

		List<Course> courses = courseRepository.findByInstructor(instructorOptional.get());
		return courses.stream().map(EntityToDTOConverter::convertToCourseDTO).toList();
	}

	@Override
	public PageRespose<InstructorDto> getAllInstructors(int pageNumnber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumnber, pageSize);
		Page<Instructor> page =  instructorRepository.findAll(pageable);
		PageRespose<InstructorDto> pageRespose = new PageRespose<>();
		pageRespose.setToatalPage(page.getTotalPages());
		pageRespose.setSize(page.getSize());
		pageRespose.setTotalElements(page.getTotalElements());
		pageRespose.setContent(page.getContent().stream().map(EntityToDTOConverter::convertToInstructorDTO).collect(Collectors.toList()));
		pageRespose.setLastPage(page.isLast());
		return pageRespose;
	}

	@Override
	public Set<StudentDto> getInstructorsStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Instructor> instructorOptional = instructorRepository.findById(id);
		if(!instructorOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		Instructor instructor = instructorOptional.get();


		return instructor.getCourses().stream()
				.flatMap(course -> course.getStudents().stream())
				.map(student -> EntityToDTOConverter.convertToStudentDto(student))
				.collect(Collectors.toSet());
	}

}
