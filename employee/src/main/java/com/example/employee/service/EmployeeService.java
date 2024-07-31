package com.example.employee.service;

import java.util.List;

import com.example.employee.vo.Employee;

/**
 * 
 * @author N.Chitturi
 *
 */
public interface EmployeeService {

	/**
	 * @param name
	 * @return
	 */
	public Employee getEmployeeByName(String name);

	/**
	 * @param employee
	 * @return
	 */
	public Employee saveEmployee(Employee employee);

	/**
	 * @param employee
	 * @return
	 */
	public Employee updateEmployee(Employee employee);

	/**
	 * @param name
	 * @return
	 */
	public String deleteEmployee(String name);

	/**
	 * @param deptName
	 * @return
	 */
	public List<Employee> getAllEmployeesByDept(String deptName);

}
 