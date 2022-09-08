
package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTests {

	@Mock
	private UserRepository userRepository;

	private UserService service;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		service = new UserService(userRepository);

	}

	@Test
	void searchUserTest() {

		System.out.println("searchUser: BEGIN");

		List<User> data = new ArrayList<User>();
		String[] usernames = { "nathan", // 0
				"bob", // 1
				"B0b", // 2
				"nathanN", // 3
				"L", // 4
				"jacOp", // 5
				"Heater", // 6
				"H3athnr"// 7
		};

		for (int x = 0; x < usernames.length; x++) {
//			User user=new User(0, "e", "p", "f", "l", usernames[x]);
			User user = new User();
			user.setUsername(usernames[x]);
			data.add(user);
		}
		when(userRepository.findAll()).thenReturn(data);

		List<User> a = new ArrayList<User>();
		a.add(data.get(0));
		a.add(data.get(3));
		a.add(data.get(6));
		a.add(data.get(7));
		assertEquals(a, service.searchUsers("h"));
		assertEquals(a, service.searchUsers("H"));

		List<User> b = new ArrayList<User>();
		b.add(data.get(0));
		b.add(data.get(3));
		b.add(data.get(7));

		assertEquals(b, service.searchUsers("n"));
		assertEquals(b, service.searchUsers("N"));

		List<User> c = new ArrayList<User>();
		c.add(data.get(0));
		c.add(data.get(3));
		c.add(data.get(7));

		assertEquals(c, service.searchUsers("ah"));

		List<User> d = new ArrayList<User>();
		d.add(data.get(5));
		assertEquals(d, service.searchUsers("co"));

		List<User> e = new ArrayList<User>();
		e.add(data.get(6));
		assertEquals(e, service.searchUsers("eat"));
	}

}
