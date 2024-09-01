package com.aurionpro.dbconnect.exceptions;

public class ClientNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5358726303763360319L;

	@Override
	public String getMessage()
	{
		return "Client you are serarching for is not present";
	}
}
