package com.assesment.employee_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class EmployeeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
