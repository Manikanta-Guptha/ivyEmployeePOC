package com.example.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.EmployeeEntity;

/**
 * 
 * @author N.Chitturi
 *
 */

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

	/**
	 * @param name
	 * @return
	 */
	EmployeeEntity findByName(String name);

	/**
	 * @param deptName
	 * @return
	 */
	List<EmployeeEntity> findByDept(String deptName);
}
