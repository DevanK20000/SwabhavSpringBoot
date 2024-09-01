package com.aurionpro.dbconnect.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.dbconnect.errors.StudentErrorResponse;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelsStudentNotFoundException(StudentNotFoundException exception){
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelsStudentException(MethodArgumentTypeMismatchException exception){
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setErrorMessage("Invalid data type");
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handelsStudentBlakNameException(MethodArgumentNotValidException exception){
//		StudentErrorResponse errorResponse = new StudentErrorResponse();
//		errorResponse.setErrorMessage(exception.getFieldError().getDefaultMessage());
//		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		errorResponse.setTimeStamp(System.currentTimeMillis());
//		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Map<String, String>> handelsStudentBlakNameException(MethodArgumentNotValidException exception){
		
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach(
					error -> {
						errors.put(((FieldError) error).getField(), error.getDefaultMessage());
					}
				);
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
