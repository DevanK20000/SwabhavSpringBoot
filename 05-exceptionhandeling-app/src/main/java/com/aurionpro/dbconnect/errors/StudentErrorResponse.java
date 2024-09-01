package com.aurionpro.dbconnect.errors;

import lombok.Data;

@Data
public class StudentErrorResponse {
	private int statusCode;
	private String errorMessage;
	private Long timeStamp;
}
