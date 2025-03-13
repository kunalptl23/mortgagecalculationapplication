package com.demo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
* This is the exception class to handle runtime exception in the application
*/
@Component
public class MortgageCalculationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	private String code;
	
	public MortgageCalculationException() {
		
	}
	public MortgageCalculationException(String code, HttpStatus status, String message) {
        super(message);
        this.code=code;
        this.status= status;
    }
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
