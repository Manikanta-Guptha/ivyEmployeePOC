package com.example.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.department.exception.DeptNotFoundException;
import com.example.department.vo.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "http://localhost:8080/employee/employees/";

	public List<Employee> getAllEmployeesBydeptName(String deptName) {

		try {
			List<Employee> employees = (List<Employee>) restTemplate.getForObject(URL + deptName, List.class);
			return employees;
		} catch (Exception e) {
			throw new DeptNotFoundException(e.getMessage());
		}
	}
}
