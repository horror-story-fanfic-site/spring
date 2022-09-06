/**
 * 
 */
package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

/**
 * @author wahoo
 *
 */
class UserServiceTests {
	
	@Mock
	private UserRepository userRepository;
	
	private UserService service;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		service=new UserService(userRepository);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void searchUserTest() {
		
		System.out.println("searchUser: BEGIN");
		
		List<User> data=new ArrayList<User>();
		String[] usernames= {
				"nathan",//0
				"bob",//1
				"B0b",//2
				"nathanN",//3
				"L",//4
				"jacOp",//5
				"Heater",//6
				"H3atnr"//7
		};
		data.add(new User(0, "e", "p", "f", "l", "nathan"));
//		for(int x=0;x<usernames.length;x++) {
////			User user=new User(0, "e", "p", "f", "l", usernames[x]);
//			User user=new User();
//			user.setUsername(usernames[x]);
//			data.add(user);
//		}
		for(int x=0;x<data.size();x++) {
			System.out.println(data.get(x).getUsername());
		}
//		when(userRepository.findAll()).thenReturn(data);
		
		List<User> a = new ArrayList<User>();
		a.add(data.get(0));
		a.add(data.get(3));
		a.add(data.get(6));
		assert(a.equals(service.searchUsers("h")));
		assert(a.equals(service.searchUsers("H")));
		
		System.out.println("TEST a");
		
		List<User> b = new ArrayList<User>();
		b.add(data.get(0));
		b.add(data.get(3));
		b.add(data.get(7));
		assert(b.equals(service.searchUsers("n")));
		assert(b.equals(service.searchUsers("N")));
		
		List<User> c = new ArrayList<User>();
		c.add(data.get(0));
		c.add(data.get(3));
		c.add(data.get(7));
		assert(c.equals(service.searchUsers("ah")));

		List<User> d = new ArrayList<User>();
		assert(d.equals(service.searchUsers("co")));

		List<User> e = new ArrayList<User>();
		e.add(data.get(6));
		assert(e.equals(service.searchUsers("eat")));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
