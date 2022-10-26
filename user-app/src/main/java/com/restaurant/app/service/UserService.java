package com.restaurant.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.UserDto;
import com.restaurant.app.entity.User;
import com.restaurant.app.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void addUser(UserDto users) {

		User savedUser=modelMapper.map(users, User.class);
		userRepo.save(savedUser);
	}

	public UserDto getUser(Integer userId) {
		User getuser=userRepo.findById(userId).orElseThrow();
		UserDto userDto=modelMapper.map(getuser, UserDto.class);
		return userDto;
	}

}
