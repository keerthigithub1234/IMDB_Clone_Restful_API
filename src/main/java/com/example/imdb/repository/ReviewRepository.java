package com.example.imdb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Review;
import com.example.imdb.requestdto.ReviewRequestDto;

import jakarta.validation.Valid;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer> {
	
	@Query("select r from Review r where r.movie.movieId=?1")
	public List<Review> findReviewByMovieId(int movieId);

	@Query("select AVG(r.reviewRating) from Review r where r.movie.movieId=?1")
	public float avgRating(int movieId);

	


}
