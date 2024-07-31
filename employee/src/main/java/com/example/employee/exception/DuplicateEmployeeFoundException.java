package com.example.employee.exception;

public class DuplicateEmployeeFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8230994407469658516L;

	public DuplicateEmployeeFoundException(String msg) {
		super(msg);
	}
}
