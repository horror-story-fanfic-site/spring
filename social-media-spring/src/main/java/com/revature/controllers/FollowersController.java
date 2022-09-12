package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.dtos.FollowerRequest;
import com.revature.models.User;
import com.revature.services.UserService;


@RequestMapping("/followers")
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FollowersController {

	private final UserService userServ;
	
	@Autowired
	public FollowersController(UserService userServ) {
	super();
	this.userServ=userServ;
	}
	/**
	 * Supposed to allow user to follow another user
	 * @param user
	 * @return user
	 */
	@Authorized
	@PostMapping(value="/follow")
	public ResponseEntity<User> insert(@RequestBody FollowerRequest toFollow, HttpSession session) {

		Optional<User> searchFollower = userServ.findUserFollowRequest(toFollow.getUserName());
		if(!searchFollower.isPresent()) {
            return ResponseEntity.badRequest().build();
        }else {
        	User currentUser = (User) session.getAttribute("user");
        	if(currentUser.getId() == searchFollower.get().getId()) {
        		return ResponseEntity.badRequest().build();
        	}
        	currentUser.getPeopleFollowed().add(searchFollower.get());
        	searchFollower.get().getFollowers().add(currentUser);
        	userServ.save(searchFollower.get());
        	return ResponseEntity.ok(userServ.save(currentUser));
        }
		
	}
	
	/**
	 * returns a list of accounts the current user is following
	 * @param session
	 * @return
	 */
	@Authorized
	@GetMapping(value="/followinglist")
	public ResponseEntity<List<String>> getAllFollowing(HttpSession session){
		List<String> followingUsernames= new ArrayList();
		List<User> userList = new ArrayList<>();
		User currentUser = (User) session.getAttribute("user");
		userList = currentUser.getPeopleFollowed();
		
		for(int i=0; i<userList.size(); i++) {
			String temp = userList.get(i).getUsername();
			followingUsernames.add(temp);
			}
		
		return ResponseEntity.ok(followingUsernames);
		
	}
	
	@Authorized
	@GetMapping(value="/followerlist")
	public ResponseEntity<List<User>> getAllFollowers(HttpSession session){
		User currentUser = (User) session.getAttribute("user");
		return ResponseEntity.ok(currentUser.getFollowers());
		
	}
	
}
