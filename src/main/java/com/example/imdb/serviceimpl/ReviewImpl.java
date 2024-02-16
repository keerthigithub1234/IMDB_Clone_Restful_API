package com.example.imdb.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.Review;
import com.example.imdb.entity.User;
import com.example.imdb.exceptionhandling.MovieNotFoundByIdException;
import com.example.imdb.exceptionhandling.MoviesNotPresentException;
import com.example.imdb.exceptionhandling.ReviewDataNotPresent;
import com.example.imdb.exceptionhandling.ReviewNotfoundByIdException;
import com.example.imdb.exceptionhandling.UserNotFoundByIdException;
import com.example.imdb.repository.MovieRepository;
import com.example.imdb.repository.ReviewRepository;
import com.example.imdb.repository.UserRepository;
import com.example.imdb.requestdto.ReviewRequestDto;
import com.example.imdb.responsedto.MovieResponseDto;
import com.example.imdb.responsedto.ReviewResponseDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.service.ReviewService;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class ReviewImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewrepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userrepository;



	private Review convertToReview(ReviewRequestDto reqRev) {

		Review r = new Review();
		r.setReviewMessage(reqRev.getReviewMessage());
		r.setReviewRating(reqRev.getReviewRating());
		return r;

	}

	private ReviewResponseDto convertToReviewResponse(Review r) {

		ReviewResponseDto resp = new ReviewResponseDto();
		resp.setReviewMessage(r.getReviewMessage());
		resp.setReviewRating(r.getReviewRating());
		return resp;

	}

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> insertReview(@Valid ReviewRequestDto req, int userId,
			int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> updateReviewById(int reviewId, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> deleteReviewById(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> readAllReview() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> findReviewById(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<ReviewResponseDto>> updateReviewById(@Valid ReviewRequestDto request,
			int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ReviewResponseDto>>> findReviewByMovieId(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}










}
