package com.mobiles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler() {
		return new ResponseEntity<>("global/ Enter  a correct Brand name", HttpStatus.ACCEPTED);
	}
}
