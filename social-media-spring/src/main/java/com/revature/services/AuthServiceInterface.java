/**
 * 
 */
package com.revature.services;

import java.util.Optional;

import com.revature.models.User;
import com.revature.services.*;

/**
 * @author wahoo
 *
 */
public interface AuthServiceInterface {
	
    public Optional<User> findByCredentials(String email, String password) ;

    public User register(User user) ; 

}
