package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Category findById(Long id);
}
