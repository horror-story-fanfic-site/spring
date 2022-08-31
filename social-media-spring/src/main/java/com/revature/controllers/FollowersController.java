package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
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
	@PostMapping(value="/followers")
	public User insert(User user, HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		//currentUser.getFollowingList().add(user)
		userServ.save(currentUser);
		return user;
		
	}
}
