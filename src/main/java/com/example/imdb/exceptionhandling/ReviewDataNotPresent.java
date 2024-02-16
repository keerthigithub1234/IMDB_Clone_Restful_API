package com.example.imdb.exceptionhandling;

public class ReviewDataNotPresent  extends RuntimeException{
	
	private String message;

	public ReviewDataNotPresent(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	
	
	

}
