package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
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
	public ResponseEntity<User> insert(User user, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		currentUser.getFollowingList().add(user);
		session.setAttribute("user", currentUser);
		return ResponseEntity.ok(userServ.save(currentUser));
		
	}
	
	@GetMapping(value="/list")
	@Authorized
	public ResponseEntity<List<User>> getAllFollowing(HttpSession session){
		User currentUser = (User) session.getAttribute("user");
		return ResponseEntity.ok(currentUser.getFollowingList());
		
	}
}