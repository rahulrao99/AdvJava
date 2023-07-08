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
import com.app.entities.Course;
import com.app.service.CourseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

	@Autowired
	private CourseService cService;
	
	public CourseController() {
		System.out.println("in def ctor of " +getClass());
	}
	
	@GetMapping
	public List<Course> listCrs(){
		System.out.println("in list emps");
		return cService.getAllCourses();
	}
	
	@PostMapping
	public ResponseEntity<?> saveCourseDetails(@RequestBody Course transientCour){
		System.out.println("in save "+transientCour);
		return new ResponseEntity<>(cService.addCourseDetails(transientCour),HttpStatus.CREATED);
	}
	
	@PutMapping
	public Course updateCourseDetails(@RequestBody Course transientCour) {
		
		System.out.println("in update course " +transientCour);
		return cService.updateCourseDetails(transientCour);
	}
	
	@DeleteMapping("/{cid}")
	public ApiResponse deleteCourseDetails(@PathVariable Long id) {
		System.out.println("in del emp dtls " +id);
		return new ApiResponse(cService.deleteCourseDetails(id));
	}
	
	

}
