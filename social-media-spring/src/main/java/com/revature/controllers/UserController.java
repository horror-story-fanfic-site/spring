package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;


/**
 * This controller enables the user to update their username and description 
 * 
 * @author Jordan Parsa
 * @version 1.0
 * @since 31-08-2022
 * 
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
	private final UserService userService;
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/updateusername")
	public String updateUsername(HttpSession session, HttpServletRequest req) {
		User sessionUser = (User) session.getAttribute("user");
		User user = userService.findByUsernameCredentials(sessionUser.getUsername(), sessionUser.getPassword()).get();
		//User user = service.findByCredentials(sessionUser.getEmail(), sessionUser.getPassword()).get();
		String username = req.getParameter("newUsername");
		user.setUsername(username);
		try {
			userService.save(user);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "false";
	}

	@PostMapping("/updatedescription")
	public String updateDescription(HttpSession session, HttpServletRequest req) {
		User sessionUser = (User) session.getAttribute("user");
		User user = userService.findByUsernameCredentials(sessionUser.getUsername(), sessionUser.getPassword()).get();
		//User user = service.findByCredentials(sessionUser.getEmail(), sessionUser.getPassword()).get();
		String description = req.getParameter("newDescription");
		user.setDescription(description);
		try {
		userService.save(user);
		return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	
	/**
	 * The controller method to change the birthday of the user
	 * @param session the HTTP session
	 * @param req the HTTPServlet req
	 * @return A string stating whether or not the birthday was changed
	 */
	@PostMapping("/changeBirthday")
	public String updateBirthday(HttpSession session, HttpServletRequest req) {
		
		User sessionUser = (User) session.getAttribute("user");
		User user = userService.findByUsernameCredentials(sessionUser.getUsername(), sessionUser.getPassword()).get();
		
		
		String newBirthDay = req.getParameter("newBirthDay");
		String newBirthMonth = req.getParameter("newBirthMonth");
		String newBirthYear = req.getParameter("newBirthYear");
		
		
		return userService.changeDoB(user, newBirthDay, newBirthMonth, newBirthYear);
	}
	
	/**
	 * 
	 * @param session the HTTP session
	 * @param req the HTTPServlet req
	 * @return a string stating if the profile picture has changed
	 */
	@PostMapping("/changeProfilePicture")
	public String updatePicture(HttpSession session, HttpServletRequest req) {
		
		User sessionUser = (User) session.getAttribute("user");
		User user = userService.findByUsernameCredentials(sessionUser.getUsername(), sessionUser.getPassword()).get();
		
		String newProfilePicture = req.getParameter("newProfilePicture");
		
		return userService.changeProfilePicture(user, newProfilePicture);
	}


	@PostMapping("/search")
	public ResponseEntity<List<User>> searchUser(HttpServletRequest req){
		String query=req.getParameter("query");
		return ResponseEntity.ok(userService.searchUsers(query));
	}
	
	// view one user, BUT this functionality should already be handled by the login controller so this may be irrelevant.
//	@GetMapping("/viewUser")
//	public User findUser(HttpSession session, HttpServletRequest req) {
//		
//		User sessionUser = (User) session.getAttribute("user");
//		User user = userService.findByUsernameCredentials(sessionUser.getUsername(), sessionUser.getPassword()).get();
//		
//		return userService.getuserById(user.getId());
//		
//	}
	

}
