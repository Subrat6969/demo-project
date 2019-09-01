package com.customException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomerException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(CustomerException ex,
			WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), HttpStatus.CONFLICT);

		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

}
