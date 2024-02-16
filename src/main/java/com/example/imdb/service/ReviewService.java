package com.example.imdb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.Review;
import com.example.imdb.entity.User;
import com.example.imdb.requestdto.ReviewRequestDto;
import com.example.imdb.responsedto.ReviewResponseDto;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

public interface ReviewService 
{

	ResponseEntity<ResponseStructure<ReviewResponseDto>> insertReview(@Valid ReviewRequestDto req, int userId,int movieId);
	
	ResponseEntity<ResponseStructure<ReviewResponseDto>> updateReviewById(int reviewId, String message);	

	ResponseEntity<ResponseStructure<ReviewResponseDto>> deleteReviewById(int reviewId);

	ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> readAllReview();

	ResponseEntity<ResponseStructure<ReviewResponseDto>> findReviewById(int reviewId);

	ResponseEntity<ResponseStructure<ReviewResponseDto>> updateReviewById(@Valid ReviewRequestDto request,int reviewId);

	ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> findReviewByMovieId(int movieId);

	

	

	

	

}
