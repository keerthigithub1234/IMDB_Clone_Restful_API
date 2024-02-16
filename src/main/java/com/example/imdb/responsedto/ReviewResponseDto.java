package com.example.imdb.responsedto;

import java.util.Map;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.User;

public class ReviewResponseDto {
	
	private int reviewId;
	private String reviewMessage;
	private float reviewRating;
	

	public float getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(float reviewRating) {
		this.reviewRating = reviewRating;
	}

	
	private Map<String, String> options;

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewMessage() {
		return reviewMessage;
	}

	public void setReviewMessage(String reviewMessage) {
		this.reviewMessage = reviewMessage;
	}

	

	

}
