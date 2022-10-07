package com.restaurant.app.feignMenu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="menu-app", url="http://localhost:8092")
public interface MenuFeignClient {

	@GetMapping("/getMenu/{restaurantId}")
	public MenuDto getMenu(@PathVariable("restaurantId") Integer restaurantId);
}
