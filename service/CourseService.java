package com.app.service;

import java.util.List;

import com.app.entities.Course;

public interface CourseService {
	
	List<Course> getAllCourses();
	
	Course getCourseDetails(Long cid);
	
	Course updateCourseDetails(Course transientCour );

	Course addCourseDetails(Course transientCour);

	String deleteCourseDetails(Long cid);

	
	
	//AuthRespDTO authenticateCourse(AuthRequestDTO request);
	
	
}
