package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.RestaurantDto;
import com.restaurant.app.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/addRestaurant")
	public RestaurantDto addRestaurant(@RequestBody RestaurantDto restaurant) {
		
		RestaurantDto savedRestaurant =restaurantService.saveRestaurant(restaurant);
		return savedRestaurant;
	}
	
	@GetMapping("/getRestaurant/{id}")
	public RestaurantDto geRestaurantById(@PathVariable Integer id) {
		
		RestaurantDto getRestaurant =restaurantService.getRestaurantById(id);
		return getRestaurant;
	}
	
	@PutMapping("/updateRestaurant/{id}")
	public RestaurantDto updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantDto restaurant) {
		RestaurantDto updatedRestaurant= restaurantService.updateRestaurant(id,restaurant);
		return updatedRestaurant;
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public void deleteRestaurant(@PathVariable Integer id) {
		restaurantService.deleteRestaurant(id);
	}
	
	
	
}













