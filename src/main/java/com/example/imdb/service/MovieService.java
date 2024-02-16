package com.example.imdb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.imdb.entity.Movie;
import com.example.imdb.requestdto.MovieRequestDto;
import com.example.imdb.responsedto.MovieResponseDto;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

public interface MovieService {
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> insertMovie( MovieRequestDto  movie);
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> updateMovieById(int movieId, MovieRequestDto movieRequest);
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> deleteMovieById(int movieId);
	
	ResponseEntity<ResponseStructure<List<MovieResponseDto>>> readAllMovies();
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieById(int movieId);
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieByGenre(String genre);
	
	ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieByName(String name);

	
	

}
