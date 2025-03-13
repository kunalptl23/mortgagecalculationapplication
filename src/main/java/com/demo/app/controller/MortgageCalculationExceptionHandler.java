package com.demo.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.app.exception.MortgageCalculationException;
import com.demo.app.resource.Errors;
import com.demo.app.resource.Error;
/**
 * This is the exception handler class for Mortgage calculation exception
 */

@RestControllerAdvice
public class MortgageCalculationExceptionHandler {
	@ExceptionHandler(MortgageCalculationException.class)
	public ResponseEntity<Object> handleMortgageCalculationException(MortgageCalculationException ex) {
		Errors errors= new Errors();
		Error error = new Error();
		error.setCode(ex.getCode());
		error.setMessage(ex.getMessage());
		error.setStatus(ex.getStatus().value());
		errors.setError(error);
		return new ResponseEntity<>(errors, ex.getStatus());
	}
}
