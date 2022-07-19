package com.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@CreationTimestamp
	private LocalDateTime purchaseDate;
	
	private String condition_note;
	
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Category category;
	
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Assignment assignment_status;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Employee employee;
	  
}
