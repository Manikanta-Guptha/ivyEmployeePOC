package com.example.department.service;

import java.util.List;

import com.example.department.vo.Employee;

public interface DepartmentService {

	List<Employee> getAllEmployeesBydeptName(String deptName);

}
