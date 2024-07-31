package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.exception.DeptNotFoundException;
import com.example.employee.exception.DuplicateEmployeeFoundException;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.vo.Employee;

import jakarta.websocket.DeploymentException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	private static final String EMPLOYEE_DETAILS = "Employee details not present with name : ";

	@Override
	public Employee saveEmployee(Employee employee) {
		EmployeeEntity existingEmp = employeeDao.findByName(employee.getName());
		if (existingEmp == null) {
			EmployeeEntity entity = new EmployeeEntity();
			BeanUtils.copyProperties(employee, entity);
			EmployeeEntity savedEntity = employeeDao.save(entity);
			BeanUtils.copyProperties(savedEntity, employee);
			return employee;
		}
		throw new DuplicateEmployeeFoundException("Employee with name : " + employee.getName() + " is already exists");
	}

	@Override
	public Employee getEmployeeByName(String name) {

		EmployeeEntity entity = employeeDao.findByName(name);
		if (entity != null) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(entity, employee);
			return employee;
		}
		throw new EmployeeNotFoundException(EMPLOYEE_DETAILS + name);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		EmployeeEntity existingEmp = employeeDao.findByName(employee.getName());
		if (existingEmp != null) {
			BeanUtils.copyProperties(employee, existingEmp);
			EmployeeEntity savedEntity = employeeDao.save(existingEmp);
			BeanUtils.copyProperties(savedEntity, employee);
			return employee;
		}
		throw new EmployeeNotFoundException(EMPLOYEE_DETAILS + employee.getName());
	}

	@Override
	public String deleteEmployee(String name) {
		EmployeeEntity existingEmp = employeeDao.findByName(name);
		if (existingEmp != null) {
			employeeDao.deleteById(existingEmp.getId());
			return "successfully deleted employee with name " + name;
		}
		throw new EmployeeNotFoundException(EMPLOYEE_DETAILS + name);
	}

	@Override
	public List<Employee> getAllEmployeesByDept(String deptName) {

		List<EmployeeEntity> employees = employeeDao.findByDept(deptName);
		List<Employee> empls = new ArrayList<>();
		if (!CollectionUtils.isEmpty(employees)) {
			for (EmployeeEntity entity : employees) {
				Employee emp = new Employee();
				BeanUtils.copyProperties(entity, emp);
				empls.add(emp);
			}
			return empls;
		}
		throw new DeptNotFoundException("employees not found with dept. name : " + deptName);
	}
}
