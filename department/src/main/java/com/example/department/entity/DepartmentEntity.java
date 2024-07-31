package com.example.department.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
