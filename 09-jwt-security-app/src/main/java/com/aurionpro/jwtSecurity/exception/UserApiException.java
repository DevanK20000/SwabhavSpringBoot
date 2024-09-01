package com.aurionpro.jwtSecurity.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserApiException extends RuntimeException{
	private HttpStatus status;
	private String message;
}
