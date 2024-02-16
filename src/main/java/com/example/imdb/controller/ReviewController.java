package com.example.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.Review;
import com.example.imdb.entity.User;
import com.example.imdb.requestdto.ReviewRequestDto;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.ReviewResponseDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.service.ReviewService;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/reviews/{userId}/{movieId}")
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> insert(@RequestBody @Valid ReviewRequestDto req,@PathVariable int userId,@PathVariable int movieId){
		return reviewService.insertReview(req, userId,movieId);	
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> findReviewById(@PathVariable @Valid  int reviewId)
	{
		return reviewService.findReviewById(reviewId);
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> updateReviewById(@RequestBody @Valid ReviewRequestDto request,@PathVariable  @Valid int reviewId){
		return reviewService.updateReviewById(request, reviewId);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> deleteById(@PathVariable  @Valid int reviewId){
		return reviewService.deleteReviewById(reviewId);
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> readAll(){
		return reviewService.readAllReview();
	}
	@GetMapping("/{movieId}/reviews")
	public ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> getReviewByMovieId(@PathVariable int movieId) {
		return reviewService.findReviewByMovieId(movieId);
	}
	

}
