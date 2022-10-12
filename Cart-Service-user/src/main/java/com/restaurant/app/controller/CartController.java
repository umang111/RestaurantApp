package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.entity.AddedOrderDetails;
import com.restaurant.app.entity.Cart;
import com.restaurant.app.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/addCart/{userId}")
	public Cart createCart(@PathVariable("userId") Integer userId) {
		
		Cart cart=cartService.createCart(userId);
		return cart;
	}
	
	@PostMapping("/addOrderToCart/{userId}/{cartId}/{orderId}")
	public AddedOrderDetails addOrderToCart(@PathVariable("userId") Integer userId, @PathVariable("cartId") Integer cartId,@PathVariable("orderId") Integer orderId) throws Exception {
		AddedOrderDetails addToCart=cartService.addOrderTocart(userId,cartId,orderId);
		return addToCart;
	}
}
