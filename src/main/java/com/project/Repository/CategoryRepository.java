package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Assignment;
import com.project.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT a FROM Category a WHERE " + 
			"a.name LIKE CONCAT('%',:name)"
			)
	Category findByName(String name);
}
