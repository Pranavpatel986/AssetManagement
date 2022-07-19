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
	public Category findByName(String name) {
		return repository.findByName(name);
	}
	public String delete(int id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
		repository.deleteById(id);
		return "Deleted Success";
	}
}
