package com.aurionpro.mapping.exceptions;

public class EntityNotFoundExcepion extends RuntimeException{

	@Override
	public String getMessage()
	{
		return "Entity you are serarching for is not present";
	}
}
