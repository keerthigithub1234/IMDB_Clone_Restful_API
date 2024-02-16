package com.example.imdb.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.imdb.enums.MovieGenre;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private String movieLanguage;
	private LocalTime movieDuration;
	private float movieRating;
	
	
	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	private MovieGenre movieGenre;
	
	@OneToMany(mappedBy = "movie",fetch = FetchType.EAGER)
	private List<Review> mreviews=new ArrayList<>();


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


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


	public List<Review> getMreviews() {
		return mreviews;
	}


	public void setMreviews(List<Review> mreviews) {
		this.mreviews = mreviews;
	}

	
	
	
	
    
	
	
	
	
	
	
	

}
