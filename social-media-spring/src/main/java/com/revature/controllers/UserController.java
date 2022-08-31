package com.revature.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/updateusername")
	public String updateUsername(HttpSession session, HttpServletRequest req) {
		User sessionUser = (User) session.getAttribute("user");
		User user = service.findByCredentials(sessionUser.getEmail(), sessionUser.getPassword()).get();
		String username = req.getParameter("newUsername");
		user.setUsername(username);
		try {
			service.save(user);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "false";

	}

	@PostMapping("/updatedescription")
	public String updateDescription(HttpSession session, HttpServletRequest req) {
		User sessionUser = (User) session.getAttribute("user");
		User user = service.findByCredentials(sessionUser.getEmail(), sessionUser.getPassword()).get();
		String description = req.getParameter("newDescription");
		user.setDescription(description);
		try {
		service.save(user);
		return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";

	}

}
