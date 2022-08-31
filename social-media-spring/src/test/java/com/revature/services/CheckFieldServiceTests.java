package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckFieldServiceTests {

	@Test
	void usernameCheckTest() {

		assertEquals(true, CheckFieldService.checkUsername("Bob"));
		assertEquals(true, CheckFieldService.checkUsername("b0B"));
		assertEquals(true, CheckFieldService.checkUsername("hello"));

		assertEquals(false, CheckFieldService.checkUsername(" hello"));
		assertEquals(false, CheckFieldService.checkUsername("h@ello"));
		assertEquals(false, CheckFieldService.checkUsername("he/llo"));
		assertEquals(false, CheckFieldService.checkUsername("hel'lo"));
		assertEquals(false, CheckFieldService.checkUsername("hell`o"));
		assertEquals(false, CheckFieldService.checkUsername("hello\\"));
		assertEquals(false, CheckFieldService.checkUsername("hell`o'"));
		
	}
	
	@Test
	void checkUsernameCharTest() {
//		\\\"'@ `,/[]{}().;

		assertEquals(false, CheckFieldService.checkUsernameChar('\\'));
		assertEquals(false, CheckFieldService.checkUsernameChar('"'));
		assertEquals(false, CheckFieldService.checkUsernameChar('\''));
		assertEquals(false, CheckFieldService.checkUsernameChar('@'));
		assertEquals(false, CheckFieldService.checkUsernameChar('`'));
		assertEquals(false, CheckFieldService.checkUsernameChar(','));
		assertEquals(false, CheckFieldService.checkUsernameChar('/'));
		assertEquals(false, CheckFieldService.checkUsernameChar('['));
		assertEquals(false, CheckFieldService.checkUsernameChar(']'));
		assertEquals(false, CheckFieldService.checkUsernameChar('{'));
		assertEquals(false, CheckFieldService.checkUsernameChar('}'));
		assertEquals(false, CheckFieldService.checkUsernameChar('('));
		assertEquals(false, CheckFieldService.checkUsernameChar(')'));
		assertEquals(true, CheckFieldService.checkUsernameChar('a'));
		assertEquals(true, CheckFieldService.checkUsernameChar('F'));
		assertEquals(true, CheckFieldService.checkUsernameChar('E'));
		assertEquals(true, CheckFieldService.checkUsernameChar('b'));
		assertEquals(true, CheckFieldService.checkUsernameChar('c'));
		assertEquals(true, CheckFieldService.checkUsernameChar('d'));
		assertEquals(false, CheckFieldService.checkUsernameChar(';'));
		assertEquals(false, CheckFieldService.checkUsernameChar('.'));
	}

}
