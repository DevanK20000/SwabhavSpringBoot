package com.aurionpro.dbconnect.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7047272373596868139L;

	@Override
	public String getMessage()
	{
		return "Employee you are serarching for is not present";
	}
}
