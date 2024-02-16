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
import com.example.imdb.requestdto.MovieRequestDto;
import com.example.imdb.responsedto.MovieResponseDto;
import com.example.imdb.service.MovieService;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@PostMapping("/movies")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> insert(@RequestBody @Valid MovieRequestDto movie){
		return movieService.insertMovie(movie);
		
	}
	//
	@PutMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> updateById(@PathVariable @Valid int movieId,@RequestBody @Valid MovieRequestDto movieRequest){
		return movieService.updateMovieById(movieId, movieRequest);
		
	}
	
	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> deleteById(@PathVariable int movieId){
		return movieService.deleteMovieById(movieId);
		
	}
	
	@GetMapping("/movies")
	public ResponseEntity<ResponseStructure<List<MovieResponseDto>>> findAllMovies(){
		return movieService.readAllMovies();
	}
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findById(@PathVariable int movieId){
		return movieService.findMovieById(movieId);
		
	}
	
	@GetMapping("/genres/{genre}/movies")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findByGenre(@PathVariable String genre){
		return movieService.findMovieByGenre(genre);
		
	}
	
	
	@GetMapping("/names/{name}/movies")
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findByName(@PathVariable String name){
		return movieService.findMovieByName(name);
		
	}
	
	

}
