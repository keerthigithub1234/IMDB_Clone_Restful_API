package com.example.imdb.requestdto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.imdb.entity.Review;
import com.example.imdb.enums.MovieGenre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MovieRequestDto {

	@NotBlank(message = "Movie name cannot be blank")
	@Size(max = 255, message = "Movie name must be less than or equal to 255 characters")
	private String movieName;

	@NotBlank(message = "movieLanguage field cannot be blank")
	@NotNull(message = "movieLanguage field cannot be null")
	private String movieLanguage;

	@NotBlank(message = "movieLanguage field cannot be blank")
	@NotNull(message = "movieLanguage field cannot be null")
	private LocalTime movieDuration;


	@NotBlank(message = "movieLanguage field cannot be blank")
	@NotNull(message = "movieLanguage field cannot be null")
	private MovieGenre movieGenre;

	@NotBlank(message = "movieLanguage field cannot be blank")
	@NotNull(message = "movieLanguage field cannot be null")
	//	private float movieRating;

	private List<Review> rReviewList=new ArrayList<>();


	public List<Review> getrReviewList() {
		return rReviewList;
	}
	public void setrReviewList(List<Review> rReviewList) {
		this.rReviewList = rReviewList;
	}
	//	public float getMovieRating() {
	//		return movieRating;
	//	}
	//	public void setMovieRating(float movieRating) {
	//		this.movieRating = movieRating;
	//	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public LocalTime getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(LocalTime movieDuration) {
		this.movieDuration = movieDuration;
	}
	public MovieGenre getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(MovieGenre movieGenre) {
		this.movieGenre = movieGenre;
	}



}
