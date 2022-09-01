package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Deprecated
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
    @Override
    public Optional<User> findByUsernameCredentials(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

	@Override
	public Optional<User> findUserFollowRequest(String username, String fisrtName, String lastName) {
		return userRepository.findByUsernameAndFirstNameAndLastName(username, lastName, lastName);
	}
    
   
}

