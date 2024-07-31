package com.example.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7612668951979393438L;

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
