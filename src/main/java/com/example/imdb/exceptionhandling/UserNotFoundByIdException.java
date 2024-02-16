package com.example.imdb.exceptionhandling;

public class UserNotFoundByIdException extends RuntimeException {
	
	private String message;

	public UserNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	

}
