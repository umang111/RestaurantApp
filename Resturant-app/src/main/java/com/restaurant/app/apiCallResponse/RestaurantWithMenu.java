package com.restaurant.app.apiCallResponse;

import com.restaurant.app.dto.RestaurantDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantWithMenu {

	private RestaurantDto restaurantDto;
	private MenuDto menuDto;
}
