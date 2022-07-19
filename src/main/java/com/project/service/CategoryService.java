package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.CategoryRepository;
import com.project.entity.Category;
import com.project.exception.ResourceNotFoundException;


@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;
	
	public void save(Category category) {
		repository.save(category);
	}
	
	public List<Category> category_list() {
		return repository.findAll();
	}
	public Category findById(Long id) {
		return repository.findById(id);
	}
	public void updateCategory(Category category) {
		Category category1=findById(category.getId());
		category1.setName(category.getName());
		repository.save(category1);
	}

	public String delete(int id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
		repository.deleteById(id);
		return "Deleted Success";
	}
}
