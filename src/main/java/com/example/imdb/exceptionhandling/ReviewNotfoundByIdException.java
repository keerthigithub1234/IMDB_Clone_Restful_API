package com.example.imdb.exceptionhandling;

public class ReviewNotfoundByIdException extends RuntimeException {
	
	private String message;

	public ReviewNotfoundByIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	

}
