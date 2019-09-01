package com.customException;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	 private Date timestamp;
	  private String message;
	  private String details;
	  private HttpStatus httpCode;
	  public ExceptionResponse(Date timestamp, String message, String details,HttpStatus httpCode) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	    this.httpCode=httpCode;
	  }
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public HttpStatus getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}

}
