package com.revature.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.services.UserService;

class ProfileControllerTest {

	@Mock
	private UserService userService;

	private UserController userController;

	@Autowired
	public ProfileControllerTest(UserController userController) {
		super();
		this.userController = userController;
	}

//	@BeforeEach
//	void setUp() throws Exception {
//
//		userController = new UserController(userService);
//	}
//
//	@Test
//	void testUpdateUsername() {
//		String username = "Dawntel";
//		String password = "password";
//		
//		User initialUser = new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null);
//		User testUser =  new User(1,"bear@aol.com","password","Bod","Bold","Dawntel","pic url","i like pizza","6","5","1991",null,null,null);
//		//when(userService.findByUsernameCredentials(username, password).thenReturns(testUser);
//	}

}
