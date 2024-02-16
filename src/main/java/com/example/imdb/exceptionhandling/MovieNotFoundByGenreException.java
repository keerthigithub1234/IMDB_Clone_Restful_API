package com.example.imdb.exceptionhandling;

public class MovieNotFoundByGenreException extends RuntimeException{

	private String message;

	public MovieNotFoundByGenreException(String message) {
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
