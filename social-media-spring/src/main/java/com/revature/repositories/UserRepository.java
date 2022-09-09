package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Deprecated
    Optional<User> findByEmailAndPassword(String email, String password);
	
	/**
	 * finds the user by username and password in the database
	 * @param username the user's username
	 * @param password the user's password
	 * @return the User object that corresponds with the username and password
	 */
    Optional<User> findByUsernameAndPassword(String username, String password);
    
    Optional<User> findByUsername(String username);
    
	Optional<User> findByEmail(String email);
	
//	ResponseEntity<User> getByUsername(String username);
}
