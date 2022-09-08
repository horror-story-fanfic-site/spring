/**
 * 
 */
package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.User;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AuthServiceTest {

	@Mock
	private UserService userService;

	private AuthService authService;

	@BeforeEach
	void setUp() throws Exception {
		authService = new AuthService(userService);
	}

	@Test
	void findByCredentialsTest() {
		// Arrange
		Optional<User> initialUser = Optional.of(new User("password", "testuser"));
		Optional<User> expectedUser = Optional.of(new User("password", "testuser"));
		when(userService.findByCredentials("testuser@gmail.com", "password")).thenReturn(initialUser);

		// Act
		Optional<User> actualUser = authService.findByCredentials("testuser@gmail.com", "password");

		// Assert
		verify(userService, times(1)).findByCredentials("testuser@gmail.com", "password");
		assertEquals(expectedUser, actualUser);

	}

	@Test
	void findByEmailTest() {
		// Arrange
		Optional<User> initialUser = Optional.of(new User("password", "testuser"));
		Optional<User> expectedUser = Optional.of(new User("password", "testuser"));
		when(userService.findByEmail("testuser@gmail.com")).thenReturn(initialUser);

		// Act
		Optional<User> actualUser = authService.findByEmail("testuser@gmail.com");

		// Assert
		verify(userService, times(1)).findByEmail("testuser@gmail.com");
		assertEquals(expectedUser, actualUser);

	}

	@Test
	void registerTest() {
		// Arrange
		User initialUser = new User("password", "testuser");
		User expectedUser = new User("password", "testuser");
		when(userService.save(initialUser)).thenReturn(initialUser);

		// Act
		User actualUser = authService.register(initialUser);

		// Assert
		verify(userService, times(1)).save(initialUser);
		assertEquals(expectedUser, actualUser);

	}

}
