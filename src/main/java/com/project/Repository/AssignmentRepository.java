package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Assignment;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{
}
