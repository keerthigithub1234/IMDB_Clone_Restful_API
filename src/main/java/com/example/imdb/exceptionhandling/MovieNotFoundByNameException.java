package com.example.imdb.exceptionhandling;

public class MovieNotFoundByNameException extends RuntimeException {
	
	private String message;

	public MovieNotFoundByNameException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
