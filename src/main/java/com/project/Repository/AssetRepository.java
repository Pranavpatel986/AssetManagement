package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{
//	public List<Asset> findByName(String name);
	
	@Query("SELECT a FROM Asset a WHERE " + 
			"a.name LIKE CONCAT('%',:name)"
			)
	List<Asset> findByName(String name);
}
