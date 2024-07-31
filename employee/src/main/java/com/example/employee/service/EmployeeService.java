package com.example.employee.service;

import java.util.List;

import com.example.employee.vo.Employee;

public interface EmployeeService {

	public Employee getEmployeeByName(String name);

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public String deleteEmployee(String name);

	public List<Employee> getAllEmployeesByDept(String deptName);

}
 