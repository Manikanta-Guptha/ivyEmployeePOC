package com.example.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentGlobalException {

	@ExceptionHandler(DeptNotFoundException.class)
	public ResponseEntity<String> handleDuplicateDeptNotFoundException(DeptNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
