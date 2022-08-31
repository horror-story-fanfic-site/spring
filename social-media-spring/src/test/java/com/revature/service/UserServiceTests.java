package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.repositories.UserRepository;
import com.revature.services.UserService;
import com.revature.services.UserServiceInterface;
@SpringBootTest
class UserServiceTests {

	@Mock
	UserServiceInterface testS;
	UserRepository testR;
	
	@BeforeEach
	void setUp() throws Exception {
		//characterServ = new CharacterServiceImpl(characterDao);
		testS = new UserService(testR);
	}

	@AfterEach
	void tearDown() throws Exception{
		
	}
	@Test
	void test() {
		UserService findByCredentials = new UserService(testR);
//		UserService findByCredentials = new UserService("test@gmail.com","password");
	}

}
