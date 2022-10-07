package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.MenuDto;
import com.restaurant.app.entity.Menu;
import com.restaurant.app.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService MenuService;

	@PostMapping("/addmenu/{restaurantId}")
	private void addMenuForRestaurant(@PathVariable("restaurantId") Integer restaurantId, @RequestBody MenuDto menudto) {
		
		MenuService.addMenuForRestaurant(restaurantId,menudto);
	}
	
	@GetMapping("/getMenu/{restaurantId}")
	public MenuDto getMenu(@PathVariable("restaurantId") Integer restaurantId) {
		MenuDto menu=MenuService.getMenu(restaurantId);
		return menu;
	}
	//todo get Menu
	//todo update Menu
	//todo delete Menu
	
}