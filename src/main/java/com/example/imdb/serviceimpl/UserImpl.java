
package com.example.imdb.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.User;
import com.example.imdb.exceptionhandling.MovieNotFoundByIdException;
import com.example.imdb.exceptionhandling.UserNotFoundByIdException;
import com.example.imdb.repository.UserRepository;
import com.example.imdb.requestdto.MovieRequestDto;
import com.example.imdb.requestdto.UserRequestDto;
import com.example.imdb.responsedto.MovieResponseDto;
import com.example.imdb.responsedto.UserResponseDto;
import com.example.imdb.service.UserService;
import com.example.imdb.usuage.ResponseStructure;

@Service
public class UserImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<ResponseStructure<UserResponseDto>> addUser(UserRequestDto userRequest) {
		User user = convertToUser(userRequest);

		User user2 = userRepository.save(user);

		UserResponseDto userResponse = convertToUserResponse(user2);

		ResponseStructure<UserResponseDto> structure = new ResponseStructure<UserResponseDto>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Student Data Inserted Successfully !");
		structure.setData(userResponse);

		return new ResponseEntity<ResponseStructure<UserResponseDto>>(structure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDto>> updateUserById(int userId, UserRequestDto updatedUser) {

		Optional<User> option = userRepository.findById(userId);
		if(option.isPresent())
		{
			User existingUser = option.get();
			User user = convertToUser(updatedUser);
			user.setUserId(existingUser.getUserId());
			user = userRepository.save(user);

			UserResponseDto response = convertToUserResponse(user);

			ResponseStructure<UserResponseDto> resStr = new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.OK.value());
			resStr.setData(response);
			resStr.setMessage("user with "+ userId +" is updated successfully");

			return new ResponseEntity<ResponseStructure<UserResponseDto>>(resStr,HttpStatus.CREATED);

		}
		else
		{
			throw new UserNotFoundByIdException("user not found by id");
		}
	}



	@Override
	public ResponseEntity<ResponseStructure<UserResponseDto>> findUserById(int userId) {

		Optional<User> option = userRepository.findById(userId);		
		if(option.isPresent()) {
			User user = option.get();

			UserResponseDto response = convertToUserResponse(user);


			ResponseStructure<UserResponseDto> rs = new ResponseStructure<UserResponseDto>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("user with " + userId + " found successfully");
			rs.setData(response);

			return new  ResponseEntity<ResponseStructure<UserResponseDto>>(rs,HttpStatus.CREATED);

		}
		else
		{
			throw new UserNotFoundByIdException("user not found");
		}
	}



	private User convertToUser(UserRequestDto userRequestDto)
	{
		User user = new User();

		user.setUserName(userRequestDto.getUserName());
		user.setDateOfBirth(userRequestDto.getDateOfBirth());
		user.setUserEmail(userRequestDto.getUserEmail());
		user.setUserPassward(userRequestDto.getUserPassward());

		return user;
	}

	private UserResponseDto convertToUserResponse(User user)
	{

		UserResponseDto userResponseDto = new  UserResponseDto();
		userResponseDto.setUserName(user.getUserName());
		userResponseDto.setUserEmail(user.getUserEmail());
		userResponseDto.setDateOfBirth(user.getDateOfBirth());
		userResponseDto.setUserId(user.getUserId());

		return userResponseDto;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDto>> deleteUserById(int userId) {
		
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			userRepository.delete(user);

			UserResponseDto response = convertToUserResponse(user);

			ResponseStructure<UserResponseDto> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User Data Deleted Successfully !!");
			structure.setData(response);

			return new ResponseEntity<ResponseStructure<UserResponseDto>>(structure, HttpStatus.OK);

		} else {
			throw new UserNotFoundByIdException("Id NotFound to Delete the Data !!");
		}
	}





}
