package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.service.EmployeeService;
import com.example.employee.vo.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping("employee")
//@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping
	public Employee saveEmployee(@RequestBody @Valid Employee employee) {
		return empService.saveEmployee(employee);
	}

	@GetMapping("{name}")
	public Employee getEmployee(@PathVariable String name) {
		return empService.getEmployeeByName(name);

	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

	@DeleteMapping("{name}")
	public String deleteEmployee(@PathVariable String name) {
		return empService.deleteEmployee(name);
	}
	
	@GetMapping("employees/{deptName}")
	public List<Employee> getAllEmployeesBydeptName(@PathVariable String deptName){
		return empService.getAllEmployeesByDept(deptName);	
	}
}
