package com.example.imdb.requestdto;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.User;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReviewRequestDto {
	
	@NotBlank(message = "Review message cannot be blank")
	@Size(max = 1000, message = "Review message must be less than or equal to 1000 characters")
	private String reviewMessage;

	@NotNull(message = "Review rating cannot be null")
	private float reviewRating;

	private User user;

	private Movie movie;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getReviewMessage() {
		return reviewMessage;
	}

	public void setReviewMessage(String reviewMessage) {
		this.reviewMessage = reviewMessage;
	}

	public float getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(float reviewRating) {
		this.reviewRating = reviewRating;
	}

	
	
	

}
