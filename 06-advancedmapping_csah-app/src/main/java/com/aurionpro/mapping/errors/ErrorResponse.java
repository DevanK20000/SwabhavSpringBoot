package com.aurionpro.mapping.errors;

import lombok.Data;

@Data
public class ErrorResponse {
	private int statusCode;
	private String errorMessage;
	private Long timeStamp;
}
