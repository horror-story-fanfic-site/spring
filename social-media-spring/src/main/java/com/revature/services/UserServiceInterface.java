package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

public interface UserServiceInterface {

	
	 
	 public Optional<User> findByCredentials(String email, String password);
	 
	 public User save(User user);
	 
    public List<User> searchUsers(String search) ;

}
