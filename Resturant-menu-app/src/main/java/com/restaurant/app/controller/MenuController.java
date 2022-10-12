package com.restaurant.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.ItemsDto;
import com.restaurant.app.dto.MenuDto;
import com.restaurant.app.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService MenuService;
	
	
	@PostMapping("/menu")
	public MenuDto addmenu(@RequestBody MenuDto menu) {
		MenuDto savedMenu=MenuService.saveMenu(menu);
		return savedMenu;
	}
	
	@PostMapping("/addItems/{menuid}/{foodCategory}")
	public ItemsDto AddItems(@RequestBody ItemsDto itemdto,@PathVariable("menuid") Integer menuId,@PathVariable("foodCategory") Integer foodCategory) {
		ItemsDto saveditem = MenuService.addItems(itemdto,menuId,foodCategory);
		return saveditem;
	}

	
	@GetMapping("/getItem/{itemId}")
	public ItemsDto getItem(@PathVariable("itemId") Integer itemId) {
		ItemsDto item=MenuService.getItem(itemId);
		return item;
	}
	
	@GetMapping("/listOfItems")
	public List<ItemsDto> getAllItems(){
		List<ItemsDto> itemsDto =MenuService.getListOfItems();
		return itemsDto;
	}
	
	@GetMapping("/getmenu/{menuId}")
	public MenuDto getMenu(@PathVariable("menuId") Integer menuId) {
		MenuDto menu=MenuService.getMenu(menuId);
		return menu;
	}
	
	@GetMapping("/getmenuByRestaurantId/{restaurantId}")
	public MenuDto getMenuByRestaurantId(@PathVariable("restaurantId") Integer restaurantId) {
		MenuDto menu=MenuService.getMenuByRestaurantId(restaurantId);
		return menu;
	}
	
	@GetMapping("/getItemWithMenuIdandRestaurantId/{menuId}/{itemId}")
	public ItemsDto getItemWithMenuIdandRestaurantId(@PathVariable("menuId") Integer menuId,@PathVariable("itemId") Integer itemId) {
		
		ItemsDto getItem=MenuService.getItemWithMenuIdandRestaurantId(menuId,itemId);
		return getItem;
	}
}












