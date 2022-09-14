package com.revature.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProfileControllerTest {

	@Mock
	private UserService userService;
	
	@Mock
	private HttpSession session;

	@Mock
	private HttpServletRequest req;
	
	private UserController userController;

	@Autowired
	public ProfileControllerTest(UserController userController) {
		super();
		this.userController = userController;
	}

	@BeforeEach
	void setUp() throws Exception {

		userController = new UserController(userService);
	}

//	@ParameterizedTest
	@Test
	void testUpdateUsername() {
		
//		//arrange
//		String username = "Dawntel";
//		String password = "password";
//		
//		User initialUser = new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null);
//		User testUser =  new User(1,"bear@aol.com","password","Bod","Bold","Dawntel","pic url","i like pizza","6","5","1991",null,null,null);
//		
//		Optional<User> optionalTestUser = Optional.of(new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null));
//		when(userService.findByUsernameCredentials(username, password)).thenReturn(optionalTestUser);
//		when(userService.save(initialUser)).thenReturn(testUser);
//		
////		when(request.getSession()).thenReturn(session);
////		when(request.getSession().getAttribute("role")).thenReturn("admin");
//		//act 
//		String result = userController.updateUsername(session, req);
//		
//		//assert
//		assertEquals("true", result);
	}

}
