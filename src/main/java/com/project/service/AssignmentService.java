package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.AssignmentRepository;
import com.project.entity.Assignment;
import com.project.exception.ResourceNotFoundException;

@Service
public class AssignmentService {
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public void save(Assignment assignment) {
		assignmentRepository.save(assignment);
	}

	public Assignment findById(int id) {
		Assignment assignment=assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment", "Id", id));;
		return assignment;
	}
	
	public Assignment findByName(String name) {
		return assignmentRepository.findByName(name);
	}
}