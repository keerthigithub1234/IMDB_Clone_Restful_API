package com.example.imdb.exceptionhandling;

public class MoviesNotPresentException extends RuntimeException {
	
	private String message;

	public MoviesNotPresentException(String message) {
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
