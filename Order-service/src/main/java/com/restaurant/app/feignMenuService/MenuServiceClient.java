package com.restaurant.app.feignMenuService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="menu-service",url="http://localhost:8092")
public interface MenuServiceClient {

	@GetMapping("/getItemWithMenuIdandRestaurantId/{menuId}/{itemId}")
	public ItemsDto getItemWithMenuIdandRestaurantId(@PathVariable("menuId") Integer menuId,
			@PathVariable("itemId") Integer itemId);
		
}
