package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.apiCallResponse.RestaurantWithMenu;
import com.restaurant.app.service.RestaurantWithMenuService;

@RestController
@RequestMapping("/getRestaurantWithMenu")
public class RestaurantWithMenuController {

	@Autowired
	private RestaurantWithMenuService restaurantWithMenuService;
	
	@GetMapping("/get/{restaurantId}")
	public RestaurantWithMenu getRestaurantWithMenu(@PathVariable("restaurantId") Integer restaurantId) {
		RestaurantWithMenu restaurantWithMenu =restaurantWithMenuService.getRestaurantWithMenu(restaurantId);
		return restaurantWithMenu;
		
	}
}
