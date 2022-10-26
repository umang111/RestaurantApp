package com.restaurant.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.apiCall.MenuDto;
import com.restaurant.app.apiCall.MenuFeignClient;
import com.restaurant.app.apiCall.RestaurantWithMenu;
import com.restaurant.app.dto.RestaurantDto;
import com.restaurant.app.entity.Restaurant;
import com.restaurant.app.repository.RestaurantRepo;

@Service
public class RestaurantWithMenuService {
	
	@Autowired
	private MenuFeignClient menuFeignClient;
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public RestaurantWithMenu getRestaurantWithMenu(Integer restaurantId) {

		MenuDto menudto=menuFeignClient.getMenuByRestaurantId(restaurantId);
		Restaurant restaurant =restaurantRepo.findById(restaurantId).orElseThrow();
		RestaurantDto restaurantDto =modelMapper.map(restaurant, RestaurantDto.class);
		
		RestaurantWithMenu restaurantWithMenu =new RestaurantWithMenu();
		restaurantWithMenu.setRestaurantDto(restaurantDto);
		restaurantWithMenu.setMenuDto(menudto);
		return restaurantWithMenu;
	}

}
