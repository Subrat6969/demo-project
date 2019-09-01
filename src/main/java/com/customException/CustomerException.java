package com.customException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class CustomerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7146661658041817740L;

	public CustomerException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
}
