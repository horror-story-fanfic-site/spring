package com.revature.services;

/**This contains the tests for fields to determine if they are appropriate to enter into the database.*/
public class CheckFieldService {
	
	/**Usernames in the database should be absent of these characters.*/
	/**The test to determine if a username is valid to enter into the database.*/
	protected static boolean checkUsername(String username) {
		for(int x=0;x<username.length();x++) {
			if (!checkUsernameChar(username.charAt(x)))
				return false;
		}
		return true;
	}
	
	protected static boolean checkUsernameChar(char testee) {
		final String illegalUsernameCharacters="\\\"'@ `,/[]{}().;";
		for(int x=0;x<illegalUsernameCharacters.length();x++) {
			if (illegalUsernameCharacters.charAt(x)==testee)
				return false;
		}
		return true;
	}
}
