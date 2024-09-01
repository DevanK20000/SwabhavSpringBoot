package com.aurionpro.mapping.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.StudentDto;
import com.aurionpro.mapping.entity.Address;
import com.aurionpro.mapping.entity.Course;
import com.aurionpro.mapping.entity.Student;
import com.aurionpro.mapping.exceptions.EntityNotFoundExcepion;
import com.aurionpro.mapping.repository.CourseRepository;
import com.aurionpro.mapping.repository.StudentRepository;
import com.aurionpro.mapping.utils.EmailSender;
import com.aurionpro.mapping.utils.EntityToDTOConverter;
import com.aurionpro.mapping.utils.HtmlTableBuilder;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Autowired
	EmailSender emailSender;

	@Autowired
	CourseRepository courseRepository;

	@Override
	public StudentDto addStudent(Student student) {
		// TODO Auto-generated method stub
		return EntityToDTOConverter.convertToStudentDto(repository.save(student));
	}

	@Override
	public PageRespose<StudentDto> getAllStudents(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> studentPage = repository.findAll(pageable);
		PageRespose<StudentDto> pageRespose = new PageRespose<>();
		pageRespose.setToatalPage(studentPage.getTotalPages());
		pageRespose.setSize(studentPage.getSize());
		pageRespose.setTotalElements(studentPage.getTotalElements());


		pageRespose.setContent(studentPage.getContent().stream().map(EntityToDTOConverter::convertToStudentDto).toList());
		pageRespose.setLastPage(studentPage.isLast());
		return pageRespose;
	}

	@Override
	public StudentDto getStudent(int rollno) {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = repository.findById(rollno);
		if(!studentOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		return EntityToDTOConverter.convertToStudentDto(studentOptional.get());

	}

	@Override
	public Address getStudentAddress(int rollno) {
		// TODO Auto-generated method stub
		Optional<Student> student = repository.findById(rollno);
		if(!student.isPresent()) {
			throw new EntityNotFoundException();
		}
		return student.get().getAddress();
	}

	@Override
	public Student updateAddress(int rollno, Address address) {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = repository.findById(rollno);
		if(!studentOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		Student student = studentOptional.get();
		Address studetnAddress = student.getAddress();

		if(!(address.getBuildingName()==null)) {
			studetnAddress.setBuildingName(address.getBuildingName());
		}

		if(!(address.getCity()==null)) {
			studetnAddress.setCity(address.getCity());
		}

		if(!(address.getPincode()==0)) {
			studetnAddress.setPincode(address.getPincode());
		}

		student.setAddress(studetnAddress);
		return repository.save(student);
	}

	@Override
	public String sendStudentViaEmail(String toEmail) {
		// TODO Auto-generated method stub
		emailSender.sendEmail(toEmail,
					"All the students in student databse",
					HtmlTableBuilder.buildHtmlTable(getAllStudentsList())
				);
		return "Email send to "+toEmail;
	}

	@Override
	public List<StudentDto> getAllStudentsList() {
		// TODO Auto-generated method stub
		return repository.findAll().stream().map(EntityToDTOConverter::convertToStudentDto).toList();
	}

	@Override
	public StudentDto assignCourses(int rollno, List<Integer> courseIds) {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = repository.findById(rollno);
		if(!studentOptional.isPresent()) {
			throw new EntityNotFoundExcepion();
		}
		Student student = studentOptional.get();

		Set<Course> courses = courseIds.stream().map(courseId -> {
			Optional<Course> courseOptional = courseRepository.findById(courseId);
			if(!courseOptional.isPresent()) {
				throw new EntityNotFoundException();
			}
			return courseOptional.get();
		}).collect(Collectors.toSet());

	    student.getCourses().clear();
	    student.getCourses().addAll(courses);
	    courses.forEach(course -> course.getStudents().add(student));

		return EntityToDTOConverter.convertToStudentDto(repository.save(student));
	}



}
