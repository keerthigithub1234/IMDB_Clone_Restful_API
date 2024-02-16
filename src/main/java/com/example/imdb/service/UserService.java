package com.example.imdb.service;

import org.springframework.http.ResponseEntity;

import com.example.imdb.entity.User;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;

public interface UserService {

	

	ResponseEntity<ResponseStructure<UserResponseDto>> addUser(@Valid UserRequestDto userRequest);
	
	ResponseEntity<ResponseStructure<UserResponseDto>> updateUserById(int userId, UserRequestDto userRequest);	


	ResponseEntity<ResponseStructure<UserResponseDto>> findUserById(int userId);

	ResponseEntity<ResponseStructure<UserResponseDto>> deleteUserById(int userId);


	



	



}
