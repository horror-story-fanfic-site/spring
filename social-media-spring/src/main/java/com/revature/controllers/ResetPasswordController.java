//package com.revature.controllers;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.revature.models.User;
//import com.revature.services.UserService;
//
//public class ResetPasswordController {
//	
//	private final UserService userServ;
//	
//	@Autowired
//	public ResetPasswordController(UserService userServ) {
//		super();
//		this.userServ=userServ;
//	}
//}
//
//	
//
//	@PostMapping("/updateuser")
//	public String updateUser(HttpSession session, HttpServletRequest req) {
//		User sessionUser = (User) session.getAttribute("User");
//		User user = service.getUserService().getUserInfo(sessionUser.getUsername());
//		String email=req.getParameter("email");
//		String password=req.getParameter("password");
//		String confirm=req.getParameter("confirm");
//		user.setEmail(email);
//		if (password!=null && password.equals(confirm)) {
//			user.setPassword(password);
//		}
//		service.getUserService().updateUser(user);
//		return "redirect:/homepage/homepage.html";
//}

//package main.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import lombok.Getter;
//@Repository
//public class Service {
//	@Getter
//	private final ItemsInterface itemsService;
//	@Getter
//	private final UserInterface userService;
//	@Getter
//	private final CartInterface cartService;
//	@Autowired
//	public Service(CartInterface checkoutService, ItemsInterface itemsService, UserInterface userService
//			, CartInterface cartService) {
//		super();
//		this.itemsService = itemsService;
//		this.userService = userService;
//		this.cartService = cartService;
//	}
//}
