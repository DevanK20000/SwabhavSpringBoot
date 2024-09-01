package com.aurionpro.dbconnect.exceptions;

public class StudentNotFoundException extends RuntimeException{

	@Override
	public String getMessage()
	{
		return "Student you are serarching for is not present";
	}
}
