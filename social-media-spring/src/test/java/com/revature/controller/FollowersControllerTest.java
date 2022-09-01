package com.revature.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.controllers.FollowersController;
import com.revature.models.User;
import com.revature.services.UserService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FollowersControllerTest {

	FollowersController myFollow;
	
	@Mock
	UserService userServ;
	
	@Mock
	HttpSession session;
	
	@BeforeEach
	void setUp() throws Exception {
		myFollow = new FollowersController(userServ);
	}

	@Test
	void test() {
		User currentUser = (User) session.getAttribute("user");
		User initalVale = new User("test@gmail.com","password");
		User expectedVale = new User("test@gmail.com","password");
		when(userServ.insert(initalVale)).thenReturn(initalVale);
		when(session.getAttribute("user")).thenReturn(initalVale);
		
		User actualVale = myFollow.insert(expectedVale, "user");
	}

}
