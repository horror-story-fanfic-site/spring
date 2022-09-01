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
		Optional<User> testUser = Optional.of(new User(1, null,null, "roman", "dixon", "test", null, null, null, null, null, null, null));

		when(userServ.findUserFollowRequest("test","Roman","Dixon")).thenReturn(testUser);
		
		FollowerRequest testRequest = new FollowerRequest("test","Roman","Dixon");

		ResponseEntity<User> actualVal = myFollow.follow(testRequest, session);

		
//		verify(userServ, times(1)).findUserFollowRequest();
		assertEquals(testUser.get(), actualVal.getBody());
	}

}
