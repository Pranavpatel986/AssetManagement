package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.project.entity.Assignment;
import com.project.entity.Category;
import com.project.service.AssignmentService;
import com.project.service.CategoryService;


@SpringBootApplication
public class AssetManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementProjectApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CategoryService service;
	@Autowired
	private AssignmentService service2;
	
	
	public void saveCategory() {
		Category category1=new Category("Furniture");
		Category category2=new Category("Laptop");
		Category category3=new Category("KeyBoard");
		Category category4=new Category("Stationary");
		service.save(category1);
		service.save(category2);
		service.save(category3);
		service.save(category4);
	}
	
	public void saveAssignment() {
		Assignment a1=new Assignment(1,"Available");
		Assignment a2=new Assignment(2,"Assigned");
		Assignment a3=new Assignment(3,"Recovered");
		service2.save(a1);
		service2.save(a2);
		service2.save(a3);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		saveAssignment();
		saveCategory();
	}
}

