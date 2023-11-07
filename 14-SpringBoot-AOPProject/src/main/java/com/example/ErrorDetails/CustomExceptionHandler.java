package com.example.ErrorDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ProblemDetail onRuntimeException(RuntimeException ex) {
		
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ex.getMessage());
		return pd;
		
	}
}
