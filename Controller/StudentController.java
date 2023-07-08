package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Student;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/students")
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentService sService;
	
	public StudentController() {
		System.out.println("in def ctor of " +getClass());
	}

	@GetMapping
	public List<Student> getAllStudents() {
		System.out.println("in list students");
		return sService.getAllStudents();
	}
	
	@PostMapping
	public ResponseEntity<?>saveStudentDetails(@RequestBody Student transientStud){
		System.out.println("in save " + transientStud);
		return new ResponseEntity<>(sService.addStudentDetails(transientStud),HttpStatus.CREATED);
	}

	@PutMapping
	public Student updateStudentDetails(Student transientStud) {
		System.out.println("in update " +transientStud);
		return sService.updateStudentDetails(transientStud);
	}

	@GetMapping("/{sid}")
	public Student getStudentDetails(@PathVariable Long sid) {
		System.out.println("in get std " +sid);
		return sService.getStudentDetails(sid);
	}

	@DeleteMapping("/{sid}")
	public ApiResponse deleteStudentDetails(@PathVariable Long sid) {
		System.out.println("in del " +sid);
		return new ApiResponse(sService.deleteStudentDetails(sid));
	}
	
	
}
