package com.restaurant.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.FoodCategoryDto;
import com.restaurant.app.dto.ItemsDto;
import com.restaurant.app.dto.MenuDto;
import com.restaurant.app.entity.FoodCategory;
import com.restaurant.app.entity.Items;
import com.restaurant.app.entity.Menu;
import com.restaurant.app.repository.FoodCategoryRepo;
import com.restaurant.app.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FoodCategoryRepo foodCategoryRepo;

	public void addMenuForRestaurant(Integer restaurantId, MenuDto menuDto){

		Menu menu=new Menu();
		menu.setRestaurantId(restaurantId);
		List<ItemsDto> itemDtos=menuDto.getItems();
		List<Items> menuobject =itemDtos.stream().map(oneItem->DtoToItems(oneItem)).collect(Collectors.toList());
		menu.setItems(menuobject);
		menuRepository.save(menu);
	}

	public MenuDto getMenu(Integer restaurantId) {

		Menu menuData = menuRepository.findByRestaurantId(restaurantId);
		MenuDto menu=new MenuDto();
		menu.setRestaurantId(menuData.getRestaurantId());
		menu.setId(menuData.getId());
		List<Items> itemDtos=menuData.getItems();
		List<ItemsDto> menuobject =itemDtos.stream().map(oneItem->ItemsToDto(oneItem)).collect(Collectors.toList());
		menu.setItems(menuobject);
		
		return menu;
	}
	
	public Items DtoToItems(ItemsDto oneItem){
		Integer categoryId =oneItem.getCategoryId();
		FoodCategory foodCategory =foodCategoryRepo.findById(categoryId).get();
//		if(!foodCategory.isPresent()) {
//			log.error("category does not exist"+categoryId);
//		}
		Items item =modelMapper.map(oneItem, Items.class);
		item.setFoodCategory(foodCategory);
		return item;
	}
	
	public ItemsDto ItemsToDto(Items item) {
		Integer categoryId =item.getCategoryId();
		FoodCategory foodCategory =foodCategoryRepo.findById(categoryId).get();
		FoodCategoryDto foodCategoryDto = modelMapper.map(foodCategory, FoodCategoryDto.class);
		ItemsDto itemsDto= modelMapper.map(item, ItemsDto.class);
		itemsDto.setFoodCategoryDto(foodCategoryDto);
		return itemsDto;
	}

//	public void addMenuForRestauransst(Integer restaurantId, MenuDto menuDto) {
//		
//		Menu menu= new Menu();	
//		
//		menu.setRestaurantName("dhaba");
//		menu.setRestaurantLocation("bhoker");
//		menu.setRestaurantId(restaurantId);
//		List<Items> itemslist=menuDto.getItemsList().stream().map(oneitem->modelMapper.map(oneitem, Items.class)).toList();
//		menu.setItems(itemslist);
//		
//		menuRepository.save(menu);
////		menu.setItems(null);
////		List<ItemsDto> items=menuDto.getItemsList().stream().map(getitem->additems(getitem)).collect(Collectors.toList());
//		
//	}
	

	
	


}
