package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
}
