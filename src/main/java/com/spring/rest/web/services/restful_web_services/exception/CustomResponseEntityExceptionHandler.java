package com.spring.rest.web.services.restful_web_services.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.rest.web.services.restful_web_services.user.UserNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getFieldError().getDefaultMessage() , request.getDescription(false));
		
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}
