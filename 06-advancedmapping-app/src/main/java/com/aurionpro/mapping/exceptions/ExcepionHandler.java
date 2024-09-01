package com.aurionpro.mapping.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.mapping.error.CustomErrorResponse;


@ControllerAdvice
public class ExcepionHandler {

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handelsStudentBlakNameException(MethodArgumentNotValidException exception){

		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach(
					error -> {
						errors.put(((FieldError) error).getField(), error.getDefaultMessage());
					}
				);

		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handelsStudentException(MethodArgumentTypeMismatchException exception){
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage("Invalid data type");
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handelsStudentNotFoundException(EntityNotFoundExcepion exception){
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
