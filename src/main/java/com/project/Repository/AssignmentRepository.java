package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{
	
	@Query("SELECT a FROM Assignment a WHERE " + 
			"a.value LIKE CONCAT('%',:value)"
			)
	Assignment findByName(String value);
}
