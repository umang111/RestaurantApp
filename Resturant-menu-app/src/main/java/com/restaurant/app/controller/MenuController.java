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
import com.restaurant.app.entity.Items;
import com.restaurant.app.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService MenuService;
	
	//http://localhost:8092/menu
	@PostMapping("/menu")
	public MenuDto addmenu(@RequestBody MenuDto menu) {
		MenuDto savedMenu=MenuService.saveMenu(menu);
		return savedMenu;
	}
	
	//http://localhost:8092/addItems/210/208
	@PostMapping("/addItems/{menuid}/{foodCategory}")
	public ItemsDto AddItems(@RequestBody ItemsDto itemdto,@PathVariable("menuid") Integer menuId,@PathVariable("foodCategory") Integer foodCategory) {
		ItemsDto saveditem = MenuService.addItems(itemdto,menuId,foodCategory);
		return saveditem;
	}
	
	//http://localhost:8092/addItemsList/210/208
	@PostMapping("/addItemsList/{menuid}/{foodCategory}")
	public List<ItemsDto> AddListofItems(@RequestBody List<ItemsDto> itemdto,@PathVariable("menuid") Integer menuId,@PathVariable("foodCategory") Integer foodCategory) {
		List<ItemsDto> saveditem = MenuService.addListOfItems(itemdto,menuId,foodCategory);
		return saveditem;
	}
	
	//http://localhost:8092/getItem/216
	@GetMapping("/getItem/{itemId}")
	public ItemsDto getItem(@PathVariable("itemId") Integer itemId) {
		ItemsDto item=MenuService.getItem(itemId);
		return item;
	}
	
	@GetMapping("/getListOfItems")
	public List<ItemsDto> getItemsList(){
		List<ItemsDto> listOfItems=MenuService.getItemsList();
		return listOfItems;
	}
	
	@GetMapping("/listOfItems")
	public List<Items> getAllItems(){
		List<Items> itemsDto =MenuService.getListOfItems();
		return itemsDto;
	}
	
	//http://localhost:8092/getmenu/210
	@GetMapping("/getmenu/{menuId}")
	public MenuDto getMenu(@PathVariable("menuId") Integer menuId) {
		MenuDto menu=MenuService.getMenu(menuId);
		return menu;
	}
	
	//http://localhost:8092/getmenuByRestaurantId/206
	@GetMapping("/getmenuByRestaurantId/{restaurantId}")
	public MenuDto getMenuByRestaurantId(@PathVariable("restaurantId") Integer restaurantId) {
		MenuDto menu=MenuService.getMenuByRestaurantId(restaurantId);
		return menu;
	}
	
	//http://localhost:8092/getItemWithMenuIdAndItemId/210/215
	@GetMapping("/getItemWithMenuIdAndItemId/{menuId}/{itemId}")
	public ItemsDto getItemWithMenuIdAndItemId(@PathVariable("menuId") Integer menuId,@PathVariable("itemId") Integer itemId) {
		
		ItemsDto getItem=MenuService.getItemWithMenuIdAndItemId(menuId,itemId);
		return getItem;
	}
}












