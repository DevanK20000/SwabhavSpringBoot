package com.aurionpro.mapping.service;

import java.util.List;

import com.aurionpro.mapping.dto.Coursedto;
import com.aurionpro.mapping.entity.Course;

public interface CourseService {
	Course addCourse(Coursedto coursedto);
	Course allocateCourses(int id, Integer instructorId);
	Coursedto assignStudents(int courseid, List<Integer> couresIds);
	Coursedto getCourse(int courseId);
}
