package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProfileServiceTest {
	@Mock
	private UserRepository userRepository;
	
	private UserService userService;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	
	@BeforeEach
	void setUp() throws Exception {
		
			userService = new UserService(userRepository);
	}
		
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByUsernameAndPassword() {
		
		//arrange
		String username = "Dacus";
		String password = "password";
		
		Optional<User> intUser1 = Optional.of(new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null));
		User expectedUser1 = new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null);
		when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(intUser1);
	
		//act
		Optional<User> actualUser = userService.findByUsernameCredentials(username, password);

		//assert
		verify(userRepository,times(1)).findByUsernameAndPassword(username, password);
	
		assertEquals(expectedUser1, actualUser.get());
	}
	
	@Test
	void testChangeDoB() {
		
		//arrange
		String testDay = "31";
		String testMonth = "12";
		String testYear = "1997";
		
		//initial value
		User initialUser = new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","6","5","1991",null,null,null);
		//expected value
		User expectedUser1 = new User(1,"bear@aol.com","password","Bod","Bold","Dacus","pic url","i like pizza","31","12","1997",null,null,null);
		//mapping the functionality of the method we wish to 'mock'
		when(userRepository.save(initialUser)).thenReturn(expectedUser1);
		
		//act
		String birthdayChanged = userService.changeDoB(initialUser, testDay, testMonth, testYear);
		
		//verify
		verify(userRepository,times(1)).save(initialUser);
		
		assertEquals("Birthday Changed", birthdayChanged);
		
	}
	

}
