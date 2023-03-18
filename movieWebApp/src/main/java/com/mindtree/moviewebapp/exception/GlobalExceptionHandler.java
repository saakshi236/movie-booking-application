package com.mindtree.moviewebapp.exception;

import java.util.HashMap;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.moviewebapp.dto.ResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ResponseDTO.builder()
				.message("Some Error Occured")
				.success(Boolean.FALSE)
				.status(400)
				.build()
		);
	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ResponseDTO.builder()
				.message(exception.getMessage())
				.success(Boolean.FALSE)
				.status(404)
				.build()
		);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ResponseDTO.builder()
				.message(exception.getMessage())
				.success(Boolean.FALSE)
				.status(404)
				.build()
		);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentInvalidException(MethodArgumentNotValidException exception) {
		HashMap<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ResponseDTO.builder()
				.message("Invalid field values")
				.success(Boolean.FALSE)
				.data(errors)
				.status(400)
				.build()
		);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
				ResponseDTO.builder()
				.message(exception.getMessage())
				.success(Boolean.FALSE)
				.status(405)
				.build()
		);
	}
}
