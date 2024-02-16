package com.example.imdb.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String reviewMessage;
	private float reviewRating;
	
	
	public float getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(float reviewRating) {
		this.reviewRating = reviewRating;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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
	public void setReviewId(int reviewId) {
		this.reviewId=reviewId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public String getReviewMessage() {
		return reviewMessage;
	}
	public void setReviewMessage(String reviewMessage) {
		this.reviewMessage = reviewMessage;
	}
	

}
