package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.CartDto;
import com.restaurant.app.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("addTocart/{userId}/{restaurantId}")
	public void addTOcart(@PathVariable("userId") Integer userId, @PathVariable("restaurantId") Integer restaurantId,@RequestBody CartDto cart ) {
		cartService.addTocart(userId,restaurantId,cart);
	}
}
