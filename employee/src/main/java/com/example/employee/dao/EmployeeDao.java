package com.example.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity findByName(String name);

	List<EmployeeEntity> findByDept(String deptName);
}
