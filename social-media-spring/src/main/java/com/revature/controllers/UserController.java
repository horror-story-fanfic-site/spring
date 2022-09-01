package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
	private final UserService userService;
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping("/search")
	public ResponseEntity<List<User>> searchUser(HttpServletRequest req){
		String query=req.getParameter("query");
		return ResponseEntity.ok(userService.searchUsers(query));
	}
}
