package com.example.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.entity.User;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.service.UserService;
import com.example.imdb.usuage.ResponseStructure;

import jakarta.validation.Valid;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<UserResponseDto>> addUser(@RequestBody @Valid UserRequestDto userRequest) {
		return userService.addUser(userRequest);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponseDto>> updateById(@PathVariable @Valid int userId,
			@RequestBody @Valid UserRequestDto userRequest) {
		return userService.updateUserById(userId, userRequest);

	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponseDto>> deleteUserById(@PathVariable @Valid int userId) {
		return userService.deleteUserById(userId);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponseDto>> findById(@PathVariable  int userId) {
		return userService.findUserById(userId);

	}

}
