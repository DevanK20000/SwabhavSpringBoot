package com.aurionpro.mapping.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Instructor;
import com.aurionpro.mapping.entity.Student;
import com.aurionpro.mapping.repository.CourseRepository;
import com.aurionpro.mapping.repository.InstructorRepository;
import com.aurionpro.mapping.repository.StudentRepository;
import com.aurionpro.mapping.utils.EntityToDTOConverter;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	InstructorRepository instructorRepository;
	@Autowired
	StudentRepository studentRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Override
	public Course addCourse(Coursedto coursedto) {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setCourseName(coursedto.getCourseName());
		course.setDuration(coursedto.getDuration());
		course.setFees(coursedto.getFees());
		LOGGER.info("Course added sucessfully "+course.getCourseId());
		return courseRepository.save(course);
	}

	@Override
	public Course allocateCourses(int id, Integer instructorId) {
		// TODO Auto-generated method stub
		Optional<Course> courseOptional = courseRepository.findById(id);
		Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);

		if((!courseOptional.isPresent()) || (!instructorOptional.isPresent())) {
			throw new EntityNotFoundException();
		}

		Course course = courseOptional.get();
		Instructor instructor = instructorOptional.get();

		List<Course> courses = instructor.getCourses();
		courses.add(course);
		instructor.setCourses(courses);
		course.setInstructor(instructor);
		return courseRepository.save(course);
	}

	@Override
	public Coursedto assignStudents(int courseid, List<Integer> studentIds) {
		// TODO Auto-generated method stub
		Optional<Course> courseOptional = courseRepository.findById(courseid);
		if(!(courseOptional.isPresent())) {
			throw new EntityNotFoundException();
		}
		Course course = courseOptional.get();

		Set<Student> students = studentIds.stream().map(
				studentId -> {
					Optional<Student> studentOptional = studentRepository.findById(studentId);
					if(!(studentOptional.isPresent())) {
						throw new EntityNotFoundException();
					}
					Student student = studentOptional.get();
					Set<Course> courses = student.getCourses();
					courses.add(course);
					student.setCourses(courses);
					return student;
				}
				).collect(Collectors.toSet());

		course.setStudents(students);

		return EntityToDTOConverter.convertToCourseDTO(courseRepository.save(course));
	}

	@Override
	public Coursedto getCourse(int courseId) {
		// TODO Auto-generated method stub
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if(!courseOptional.isPresent()) {
			LOGGER.error("Course "+courseId+" not found");
			throw new EntityNotFoundException();
		}
		return EntityToDTOConverter.convertToCourseDTO(courseOptional.get());
	}


}
