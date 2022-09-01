package com.revature.controllers;

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
	@PostMapping(value="/follow")
	@Authorized
<<<<<<< HEAD
	public ResponseEntity<User> follow(FollowerRequest toFollow, HttpSession session) {
=======
	public ResponseEntity<User> insert(@RequestBody FollowerRequest toFollow, HttpSession session) {
>>>>>>> 29fc2d66dc28aa820fd893617890f4889ecd934d
		Optional<User> searchFollower = userServ.findUserFollowRequest(toFollow.getUserName(), toFollow.getFirstName(), toFollow.getLastName());
		if(!searchFollower.isPresent()) {
            return ResponseEntity.badRequest().build();
        }else {
        	User currentUser = (User) session.getAttribute("user");
        	currentUser.getFollowers().add(searchFollower.get());
        	session.setAttribute("user", currentUser);
        	return ResponseEntity.ok(userServ.save(currentUser));
        }
		
	}
	
	/**
	 * returns a list of accounts the current user is following
	 * @param session
	 * @return
	 */
	@GetMapping(value="/list")
	@Authorized
	public ResponseEntity<List<User>> getAllFollowing(HttpSession session){
		User currentUser = (User) session.getAttribute("user");
		return ResponseEntity.ok(currentUser.getFollowers());
		
	}
}
