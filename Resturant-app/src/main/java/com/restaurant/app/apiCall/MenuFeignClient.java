package com.restaurant.app.apiCall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.restaurant.app.apiCallResponse.MenuDto;


@FeignClient(name="Resturant-Menu-app", url="http://localhost:8092")
public interface MenuFeignClient {

	@GetMapping("/getMenu/{restaurantId}")
	public MenuDto getMenu(@PathVariable("restaurantId") Integer restaurantId);
}
