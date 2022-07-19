package com.project.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.service.AssignmentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@CreationTimestamp
	private LocalDateTime purchaseDate;
	
	private String condition_note;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Assignment assignment_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	  

}
