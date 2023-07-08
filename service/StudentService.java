package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student addStudentDetails(Student transientStud);
	
	Student updateStudentDetails(Student transientStud);
	
	Student getStudentDetails(Long sid);
	
	String deleteStudentDetails(Long sid);
	
}
