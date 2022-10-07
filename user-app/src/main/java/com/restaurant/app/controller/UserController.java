package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.UserDto;
import com.restaurant.app.entity.User;
import com.restaurant.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	

	@PostMapping("/addUser")
	public void addUser(@RequestBody UserDto user) {
		userService.addUser(user);
	}
	
	@GetMapping("/getUser/{userId}")
	public UserDto getUser(@PathVariable("userId") Integer userId) {
		
		UserDto user =userService.getUser(userId);
		return user;
	}
}
