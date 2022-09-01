package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

public interface UserServiceInterface {

	
	 
	 public Optional<User> findByCredentials(String email, String password);
	 
	 public User save(User user);

	 public Optional<User> findByUsernameCredentials(String username, String password);
	 
	 public Optional<User> findUserFollowRequest(String username, String fisrtName, String lastName);
}
