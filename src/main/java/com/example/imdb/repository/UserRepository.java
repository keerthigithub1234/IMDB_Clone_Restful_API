package com.example.imdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.User;
import com.example.imdb.requestdto.UserRequestDto;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {



	
	

	
	

}
