package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.EmployeeRepo;
import com.project.entity.Employee;
import com.project.exception.ResourceNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public List<Employee> emp_list(){
		return repo.findAll();
	}
	
	public void saveEmp(Employee employee) {
		repo.save(employee);
	}
	public Employee findEmpById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}
}
