package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Student;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository sRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public Student addStudentDetails(Student transientStud) {
		// TODO Auto-generated method stub
		return sRepo.save(transientStud);
	}

	@Override
	public Student updateStudentDetails(Student transientStud) {
		// TODO Auto-generated method stub
		return sRepo.save(transientStud);
	}

	@Override
	public Student getStudentDetails(Long sid) {
		// TODO Auto-generated method stub
		return sRepo.findById(sid)
				.orElseThrow(()->new ResourceNotFoundException("invalid student id"));
	}

	@Override
	public String deleteStudentDetails(Long sid) {
		// TODO Auto-generated method stub
		String msg="stud id invalid";
		if(sRepo.existsById(sid)) {
			sRepo.deleteById(sid);
			msg="stud with id ="+sid+" deleted !!";
		}
		return null;
	}

}
