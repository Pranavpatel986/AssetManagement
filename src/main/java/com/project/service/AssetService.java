package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.AssetRepository;
import com.project.entity.Asset;
import com.project.entity.Assignment;
import com.project.entity.Employee;
import com.project.exception.ResourceNotFoundException;

@Service
public class AssetService {
	@Autowired
	AssetRepository assetRepository;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AssignmentService assignmentService;
	
	
	//save asset
	public void saveAsset(Asset asset) {
		asset.setAssignment_status(assignmentService.findById(1));
		assetRepository.save(asset);
	}
	
	//list of  all assets
	public List<Asset> asset_list() {
		return assetRepository.findAll();
	}
	
	//search asset based on name
	public List<Asset> findByName(String name) {
		return assetRepository.findByName(name);
	}
	
	//assign asset to emp
	public void assignAsset(Long emp_id,Long asset_id) {
		Employee employee=employeeService.findEmpById(emp_id);
		Asset asset=assetRepository.findById(asset_id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", emp_id));
		asset.setEmployee(employee);
		////////assigned id is 2
		asset.setAssignment_status(assignmentService.findById(2));
		assetRepository.save(asset);
	}
	
	
	// deassign asset to emp
	public void deAssignAsset(Long asset_id) {
		Asset asset=assetRepository.findById(asset_id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", asset_id));;
		asset.setEmployee(null);
		
		//////Recovered id is 3
		asset.setAssignment_status(assignmentService.findById(3));
		assetRepository.save(asset);
	}
	
	
	////////delete the asset//////
	public String delete(Long id) {
		Asset asset= assetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", id));
		///////assigned id is 2/////
		if(asset.getAssignment_status().getId()==2) {
			return "Asset is assigned currently cannot be deleted";
		}
		
		assetRepository.deleteById(id);
		
		return "Deleted Succefully";
	}
}
