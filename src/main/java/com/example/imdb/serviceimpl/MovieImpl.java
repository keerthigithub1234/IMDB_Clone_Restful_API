package com.example.imdb.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imdb.entity.Movie;
import com.example.imdb.enums.MovieGenre;
import com.example.imdb.exceptionhandling.MovieDataNotPresentException;
import com.example.imdb.exceptionhandling.MovieNotFoundByGenreException;
import com.example.imdb.exceptionhandling.MovieNotFoundByIdException;
import com.example.imdb.exceptionhandling.MoviesNotPresentException;
import com.example.imdb.repository.MovieRepository;
import com.example.imdb.requestdto.MovieRequestDto;
import com.example.imdb.responsedto.MovieResponseDto;
import com.example.imdb.service.MovieService;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class MovieImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;

	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> insertMovie(MovieRequestDto movieRequest) {
		Movie movie = convertToMovie(movieRequest);

		
		Movie movie2 = movieRepository.save(movie);

		MovieResponseDto movieResponse = convertToMovieResponse(movie2);
		
		ResponseStructure<MovieResponseDto> structure = new ResponseStructure<MovieResponseDto>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Movie Data Inserted Successfully");
		structure.setData(movieResponse);

		return new ResponseEntity<ResponseStructure<MovieResponseDto>>(structure, HttpStatus.CREATED);
	}
	
    //-----------------------------------------------------------------------------------
	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> updateMovieById(int movieId, MovieRequestDto updatedMovie) {
		
		Optional<Movie> option = movieRepository.findById(movieId);
		if(option.isPresent())
		{
			Movie existingMovie = option.get();
			Movie movie = convertToMovie(updatedMovie);
			movie.setMovieId(existingMovie.getMovieId());
			movie =movieRepository.save(movie);
			
			MovieResponseDto response = convertToMovieResponse(movie);
			
			ResponseStructure<MovieResponseDto> resStr = new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.OK.value());
			resStr.setData(response);
			resStr.setMessage("movie with "+ movieId +" is updated successfully");
			
			return new ResponseEntity<ResponseStructure<MovieResponseDto>>(resStr,HttpStatus.CREATED);
 			
		}
		else
		{
			throw new MovieNotFoundByIdException("movie not found");
		}
		
		
	}

	//-------------------------------------------------------------------------------------
	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> deleteMovieById(int movieId) {
		Optional<Movie> option = movieRepository.findById(movieId);		
		if(option.isPresent()) {
			Movie movie = option.get();
			
			MovieResponseDto response = convertToMovieResponse(movie);
			movieRepository.delete(movie);
			
			ResponseStructure<MovieResponseDto> rs = new ResponseStructure<MovieResponseDto>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("movie with " + movieId + " deleted successfully");
			rs.setData(response);
			
			return new  ResponseEntity<ResponseStructure<MovieResponseDto>>(rs,HttpStatus.CREATED);
			
		}
		else
		{
			throw new MovieNotFoundByIdException("movie not found");
		}
	}

	

	//--------------------------------------------------------------------------------------
	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieById(int movieId) {
		Optional<Movie> option = movieRepository.findById(movieId);		
		if(option.isPresent()) {
			Movie movie = option.get();
			
			MovieResponseDto response = convertToMovieResponse(movie);
		
			
			ResponseStructure<MovieResponseDto> rs = new ResponseStructure<MovieResponseDto>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("movie with " + movieId + " found successfully");
			rs.setData(response);
			
			return new  ResponseEntity<ResponseStructure<MovieResponseDto>>(rs,HttpStatus.CREATED);
			
		}
		else
		{
			throw new MovieNotFoundByIdException("movie not found");
		}
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieByGenre(String genre) {
		
		
		List<Movie> movieList = movieRepository.findAll();
		
		if(movieList.isEmpty())
		{
			throw new MoviesNotPresentException("no movie present");
		}
		
		List<MovieResponseDto> matchingMovies = new ArrayList<>();
		
		MovieGenre movieGenre=MovieGenre.valueOf(genre.toUpperCase());
		
		
		if(movieGenre!=null)
		{
			for(Movie movie : movieList)
			{
				if(movie.getMovieGenre().equals(movieGenre))
				{
					MovieResponseDto response = convertToMovieResponse(movie);
					matchingMovies.add(response);
					
				}
			}
		}
		
		if(matchingMovies.isEmpty())
		{
			throw new MovieNotFoundByGenreException("no movie found in this genre u specified");
		}
		
		ResponseStructure<MovieResponseDto> rs = new ResponseStructure<MovieResponseDto>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("movie with " + genre + " found successfully");
		rs.setData(matchingMovies);
		
		return new  ResponseEntity<ResponseStructure<MovieResponseDto>>(rs,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<ResponseStructure<MovieResponseDto>> findMovieByName(String name) {
		
		List<Movie> movieList = movieRepository.findAll();
		
		if(movieList.isEmpty())
		{
			throw new MoviesNotPresentException("no movies found");
		}
		
		List<MovieResponseDto> matchingMovies = new ArrayList<>();
		
		for(Movie movie : movieList)
		{
			if(movie.getMovieName().equalsIgnoreCase(name)) {
				MovieResponseDto response = convertToMovieResponse(movie);
				matchingMovies.add(response);
			}
		}
		if(matchingMovies.isEmpty())
		{
			throw new MoviesNotPresentException("no movies found with this name");
		}
		
		ResponseStructure<MovieResponseDto> rs = new ResponseStructure<MovieResponseDto>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("movie with " + name + " found successfully");
		rs.setData(matchingMovies);
		
		return new  ResponseEntity<ResponseStructure<MovieResponseDto>>(rs,HttpStatus.OK);
		
			
	}

	private Movie convertToMovie(MovieRequestDto movieRequest)
	{
		Movie movie = new Movie();
		movie.setMovieName(movieRequest.getMovieName());
		movie.setMovieDuration(movieRequest.getMovieDuration());
		movie.setMovieGenre(movieRequest.getMovieGenre());
		movie.setMovieLanguage(movieRequest.getMovieLanguage());
		movie.setMreviews(movieRequest.getrReviewList());

		return movie;
	}

	private MovieResponseDto convertToMovieResponse(Movie movie)
	{
		MovieResponseDto movieResponseDto = new MovieResponseDto();
		movieResponseDto.setMovieDuration(movie.getMovieDuration());
		movieResponseDto.setMovieGenre(movie.getMovieGenre());
		movieResponseDto.setMovieLanguage(movie.getMovieLanguage());
		movieResponseDto.setMovieName(movie.getMovieName());
		
		
		return movieResponseDto;

	}

	@Override
	public ResponseEntity<ResponseStructure<List<MovieResponseDto>>> readAllMovies() {
		List<Movie> movieList = movieRepository.findAll();
		if (!movieList.isEmpty()) {
			List<MovieResponseDto> list = new ArrayList<>();
			for (Movie movie : movieList) {

				MovieResponseDto movieResponse = convertToMovieResponse(movie);
		
				Map<String, String> o = new HashMap<>();
				o.put("reviews", "/" + movie.getMovieId() + "/reviews");
				movieResponse.setOptions(o);

				list.add(movieResponse);
			}

			ResponseStructure<List<MovieResponseDto>> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Movie Records Found");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<MovieResponseDto>>>(structure, HttpStatus.FOUND);
		} else {
			throw new MovieDataNotPresentException("No Movies Data Present!!");
		}
		
	}

	

	



}
