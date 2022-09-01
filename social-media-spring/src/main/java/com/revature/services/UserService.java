package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Deprecated
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> findByUsernameCredentials(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
    public User getuserById(int id) {
    	return userRepository.getReferenceById(id);
    }

    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    /**This is the end point for search bar.
     * Determines it by characters and followers their order.*/
    public List<User> searchUsers(String search){
    	//Grabs a list of all the current users.
    	List<User> users = new ArrayList<User>();
    	//Copies this over as to not mess with the original model.
    	users.addAll(userRepository.findAll());
    	
    	//Sets this all to lower case as this is not meant to be case sensitive.
    	search=search.toLowerCase();
    	
    	//The holder for the username.
    	String username;
    	
    	//This loops through all the usernames.
    	for(int x=0;x<users.size();x++) {
    		username=users.get(x).getUsername().toLowerCase();
    		int y, w;
    		
    		//Loop through all the characters in the search.
    		charMatch:
    		for(y=0, w=0;y<search.length();y++) {
    			
    			//Loop through all the characters in the username.
    			//This is to keep track of the order as to make it so characters before are not counted.
    			while(w<username.length()) {
    				if (search.charAt(y)==username.charAt(w)) {
    					continue charMatch;
    				}
    				w++;
    			}
    			//This is only reached if the username ran out without finding a char match.
    			break;//This will exit the loop even if there is more characters to search.
    		}
    		
    		//If the username hit the end before the characters to search hit the end this is ran.
    		if (w==username.length()) {
    			//This removes the username from the list of returns.
    			users.remove(users.get(x));
    			x--;//This is to compensate for list order.
    		}
    	}
    	return users;
    }
}
