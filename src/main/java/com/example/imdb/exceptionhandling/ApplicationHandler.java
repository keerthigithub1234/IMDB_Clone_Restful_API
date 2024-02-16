package com.example.imdb.exceptionhandling;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.imdb.usuage.ErrorStructure;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> userNotFoundById(UserNotFoundByIdException exception){

		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("user with this id is not found....!!");

		return new  ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);

	}


	@ExceptionHandler(MovieNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> movieNotFoundById(UserNotFoundByIdException exception){

		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("movie with this id is not found....!!");

		return new  ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);

	}



	@ExceptionHandler(MovieNotFoundByGenreException.class)
	public ResponseEntity<ErrorStructure> movieNotFoundByGenre(MovieNotFoundByGenreException exception){

		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("this movie genre is not present....!!");

		return new  ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MovieNotFoundByNameException.class)
	public ResponseEntity<ErrorStructure> movieNotFoundByName(MovieNotFoundByNameException exception){

		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("this movie is not present....!!");

		return new  ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);

	}


	@ExceptionHandler(MoviesNotPresentException.class)
	public ResponseEntity<ErrorStructure> moviesNotPresent(MoviesNotPresentException exception){

		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("movies not present....!!");

		return new  ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);

	}

	//this method is overridden after extending the class with ResponseEntityExceptionHandler
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<ObjectError> list = ex.getAllErrors();	
		HashMap<String,String> hashMap = new HashMap<>();
		
		for(ObjectError error : list) {
			FieldError fieldError = (FieldError) error;
			String fieldName = fieldError.getField();
			String message = error.getDefaultMessage();
			hashMap.put(fieldName, message);
		}
		return new ResponseEntity<Object>(hashMap,HttpStatus.BAD_REQUEST);
	}












}
