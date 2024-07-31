package com.example.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.service.DepartmentService;
import com.example.department.vo.Employee;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@GetMapping("employees/{deptName}")
	public List<Employee> getAllEmployeesByDeptName(@PathVariable String deptName) {
		return deptService.getAllEmployeesBydeptName(deptName);
	}
}