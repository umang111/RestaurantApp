package com.restaurant.app.apiCall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Resturant-Menu-app", url="http://localhost:8092")
public interface MenuFeignClient {

	@GetMapping("/getmenuByRestaurantId/{restaurantId}")
	public MenuDto getMenuByRestaurantId(@PathVariable("restaurantId") Integer restaurantId);
}
