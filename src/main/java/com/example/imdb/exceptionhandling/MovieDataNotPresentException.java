package com.example.imdb.exceptionhandling;

public class MovieDataNotPresentException  extends RuntimeException{
	
	private String message;

	public MovieDataNotPresentException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	

}
