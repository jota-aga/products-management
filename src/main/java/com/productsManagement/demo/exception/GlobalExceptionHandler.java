package com.productsManagement.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NameAlreadyRegisteredException.class)
	public ResponseEntity<List<String>> handleNameAlreadyRegisteredException(NameAlreadyRegisteredException e){
		List<String> errors = new ArrayList<>();
		errors.add(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleMethodArgumentNotValidExceptionException(MethodArgumentNotValidException e){
		List<String> errors = new ArrayList<>();
		
		e.getBindingResult().getAllErrors().forEach((error)-> {
			String errorMessage = error.getDefaultMessage();
			errors.add(errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<List<String>> handleProductNotFoundException(ProductNotFoundException e){
		List<String> errors = new ArrayList<>();
		errors.add(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
	
	@ExceptionHandler(NameIsNotStringException.class)
	public ResponseEntity<List<String>> handleNameIsNotStringException(NameIsNotStringException e){
		List<String> errors = new ArrayList<>();
		errors.add(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	} 
}
