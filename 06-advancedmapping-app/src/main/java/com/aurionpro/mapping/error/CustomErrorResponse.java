package com.aurionpro.mapping.error;

import lombok.Data;

@Data
public class CustomErrorResponse {
	private int statusCode;
	private String errorMessage;
	private Long timeStamp;
}
