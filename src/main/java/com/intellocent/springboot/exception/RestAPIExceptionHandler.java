package com.intellocent.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intellocent.springboot.pojo.ExceptionErrorResponse;
import com.intellocent.springboot.pojo.ObjectNotFoundException;

@ControllerAdvice
public class RestAPIExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionErrorResponse> handleException(ObjectNotFoundException exc) {

		ExceptionErrorResponse error = new ExceptionErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionErrorResponse> handleException(Exception exc) {

		ExceptionErrorResponse error = new ExceptionErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
