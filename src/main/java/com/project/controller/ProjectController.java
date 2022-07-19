package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Asset;
import com.project.entity.Category;
import com.project.entity.Employee;
import com.project.service.AssetService;
import com.project.service.CategoryService;
import com.project.service.EmployeeService;


@RestController
@RequestMapping("/")
public class ProjectController {
	@Autowired
	private AssetService asset_service;
	@Autowired
	private CategoryService category_service;
	@Autowired
	private EmployeeService employeeService;
	
	
	
	/////////get methods///////
	
	
	//////cheak working//////
	@GetMapping
	public String Home() {
		return "Application Started Successfully";
	}
	
	////////list of assets//////////
	@GetMapping("/assets")
	public List<Asset> listAsset() {
		return asset_service.asset_list();
	}
	@GetMapping("/employeed")
	public List<Employee> listEmployees() {
		return employeeService.emp_list();
	}
	
	//////////find asset by name//////////
	@GetMapping("/assetsByName")
	public List<Asset> searchAssetsByName(@RequestParam String name) {
		return asset_service.findByName(name);
	}
	
	
	/////////list of categories////////////
	@GetMapping("/categories")
	public List<Category> listCategories() {
		return category_service.category_list();
	}
	
	////////delete asset/////////
	@GetMapping("/deletecategory")
	public String deleteAsset(@RequestParam Long id) {
		return asset_service.delete(id);
	}
	
	
	////////post methods///////////
	
	
	
	/////AddAsset with assignment available/////////
	@PostMapping("/asset")
	public void saveAsset(@RequestBody Asset asset) {
		asset_service.saveAsset(asset);
	}
	
	
	//////saveEmployee
	@PostMapping("/employee")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmp(employee);
	}
	
	
	////saveCategory///////////
	@PostMapping("/category")
	public void saveCategory(@RequestBody Category category) {
		category_service.save(category);
	}
	
	///////assignAsset to emp///////////////
	@PostMapping("/assignAsset")
	public void assetAssigntoEmp(@RequestParam Long emp_id,@RequestParam Long asset_id) {
		asset_service.assignAsset(emp_id,asset_id);;
	}
	
	
	//////////recover asset////////////////
	@PostMapping("/deAssignAsset")
	public void deAssetAssigntoEmp(@RequestParam Long id) {
		asset_service.deAssignAsset(id);;
	}
	
	@PostMapping("/updateCategory")
	public void updateCategory(@RequestBody Category category) {
		category_service.updateCategory(category);
	}
	
}
