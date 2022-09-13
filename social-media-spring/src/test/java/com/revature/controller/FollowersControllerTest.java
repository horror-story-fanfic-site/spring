package com.revature.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoSession.*;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.FollowersController;
import com.revature.dtos.FollowerRequest;
import com.revature.models.User;
import com.revature.services.UserService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FollowersControllerTest {

	@Mock
	FollowersController myFollow;
	
	@Mock
	UserService userServ;
	
	@Mock
	HttpSession session;
	
//	@BeforeEach
//	void setUp() throws Exception {
//		myFollow = new FollowersController(userServ);
//	}


	@Test
	void insertFollowerTest() {
		
		// Arrange
//		User currentUser = (User) session.getAttribute("user");

//		User expectedUser = (User) session.getAttribute("user");
		
//		FollowerRequest toFollow = new FollowerRequest("testuser", "firstN", "lastN");
//		Optional<User> expectedUser = userServ.findUserFollowRequest(toFollow.getUserName());
//		//when(userServ.findUserFollowRequest("test","Roman","Dixon")).thenReturn(testUser);
//		System.out.println("CHECKPOINT: " + expectedUser);
//		
//		FollowerRequest testRequest = new FollowerRequest("testuser", "firstN", "lastN");
//
//		
//		// Act
//		
////		Optional<User> searchFollower = userServ.findUserFollowRequest(testRequest.getUserName());
//		
//		
//		// Assert
//		ResponseEntity<User> actualVal = myFollow.insert(testRequest, session);
//
//		
//		
////		verify(userServ, times(1)).findUserFollowRequest();
//		assertEquals(expectedUser, actualVal.getBody());
	}

}
