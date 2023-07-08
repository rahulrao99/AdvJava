package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entities.Course;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	public CourseRepository cRepo;
	
	@Autowired
	public ModelMapper modelmapper;
	
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Course addCourseDetails(Course transientCour) {
		// TODO Auto-generated method stub
		return cRepo.save( transientCour);
	}

	@Override
	public Course getCourseDetails(Long cid) {
		// TODO Auto-generated method stub
		return cRepo.findById(cid)
				.orElseThrow(()->new ResourceNotFoundException("Invalid course"));
	}

	@Override
	public Course updateCourseDetails(Course transientCour) {
		// TODO Auto-generated method stub
		return cRepo.save( transientCour);
	}

	
	@Override
	public String deleteCourseDetails(Long cid) {
		// TODO Auto-generated method stub
		String msg="Course id invalid";
		if(cRepo.existsById(cid)) {
			cRepo.deleteById(cid);
			msg="cid with id ="+cid+"deleted !!";
		}
		return null;
	}

}
