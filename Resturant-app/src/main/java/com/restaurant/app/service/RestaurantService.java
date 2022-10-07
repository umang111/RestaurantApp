package com.restaurant.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.RestaurantDto;
import com.restaurant.app.entity.Restaurant;
import com.restaurant.app.repository.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RestaurantDto saveRestaurant(RestaurantDto restaurant) {
		
		Restaurant Typerestaurant= RestaurantDtotoRestaurant(restaurant);
		Restaurant savedRestaurant =restaurantRepo.save(Typerestaurant);
		return restaurantToRestaurantDto(savedRestaurant);
	}

	public RestaurantDto getRestaurantById(Integer id) {
		 
		Restaurant geRestaurant = restaurantRepo.findById(id).orElseThrow();
		
		RestaurantDto typeRestaurantDto =restaurantToRestaurantDto(geRestaurant);
		return typeRestaurantDto;
	}

	public RestaurantDto updateRestaurant(Integer id, RestaurantDto restaurant) {
		
		Restaurant getRestaurant = restaurantRepo.findById(id).orElseThrow();
		getRestaurant.setName(restaurant.getName());
		getRestaurant.setLocation(restaurant.getLocation());
		
		Restaurant updateRestaurant =restaurantRepo.save(getRestaurant);
		return restaurantToRestaurantDto(updateRestaurant);
	}

	public void deleteRestaurant(Integer id) {

		restaurantRepo.deleteById(id);
	}

	
	//conversion
	public Restaurant RestaurantDtotoRestaurant(RestaurantDto restaurantDto) {
		Restaurant Restaurant=modelMapper.map(restaurantDto,Restaurant.class );
		return Restaurant;
	}
	
	
	public RestaurantDto restaurantToRestaurantDto(Restaurant restaurant) {
		RestaurantDto restaurantDto =modelMapper.map(restaurant, RestaurantDto.class);
		return restaurantDto;
	}
}







