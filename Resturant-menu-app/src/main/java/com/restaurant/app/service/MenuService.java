package com.restaurant.app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.restaurant.app.repository.ItemsRepo;
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
	
	@Autowired
	private ItemsRepo itemsRepo;

	public MenuDto saveMenu(MenuDto menu) {
		Menu savedMenu=menuRepository.save(modelMapper.map(menu, Menu.class));
		MenuDto savedMenuDto=modelMapper.map(savedMenu, MenuDto.class);
		return savedMenuDto;
	}

	public ItemsDto addItems(ItemsDto item, Integer menuId, Integer foodCategory) {
		Menu getMenu=menuRepository.findById(menuId).get();
		FoodCategory getCategory=foodCategoryRepo.findById(foodCategory).get();
		FoodCategoryDto categoryDto =modelMapper.map(getCategory, FoodCategoryDto.class);
		Items savedItems = new Items();
		savedItems.setItemName(item.getItemName());
		savedItems.setPrice(item.getPrice());
		savedItems.setFoodCategory(getCategory);
		savedItems.setMenu(getMenu);
		Items savedToDb=itemsRepo.save(savedItems);
		ItemsDto returnItme =new ItemsDto();
		returnItme.setId(savedToDb.getId());
		returnItme.setItemName(savedToDb.getItemName());
		returnItme.setPrice(savedToDb.getPrice());
		returnItme.setFoodCategoryDto(categoryDto);
		return returnItme;
	}

	public ItemsDto getItem(Integer itemId) {

		Items getItem=itemsRepo.findById(itemId).get();
		FoodCategory foodCategory=getItem.getFoodCategory();
		FoodCategoryDto foodCategoryDto =modelMapper.map(foodCategory, FoodCategoryDto.class);
		ItemsDto itemDto=new ItemsDto();
		itemDto.setId(getItem.getId());
		itemDto.setItemName(getItem.getItemName());
		itemDto.setPrice(getItem.getPrice());
		itemDto.setFoodCategoryDto(foodCategoryDto);
		return itemDto;
	}

	public MenuDto getMenu(Integer menuId) {
		Menu getMenu=menuRepository.findById(menuId).get();
		
		List<Items> items= itemsRepo.findAllByMenuid(menuId);
		List<ItemsDto> itemList=items.stream().map(getItem->chnageitemslistToDtoList(getItem)).collect(Collectors.toList());
		MenuDto menuDto=new MenuDto();
		menuDto.setMenuid(getMenu.getMenuid());
		menuDto.setMenuDiscription(getMenu.getMenuDiscription());
		menuDto.setItems(itemList);
		return menuDto;
	}

	public List<Items> getListOfItems() {

		List<Items> items= itemsRepo.findAll();
//		List<ItemsDto> itemList=items.stream().map(getItem->chnageitemslistToDtoList(getItem)).collect(Collectors.toList());
		return items;
	}

	private ItemsDto chnageitemslistToDtoList(Items getItem) {

		FoodCategory foodCategory=getItem.getFoodCategory();
		FoodCategoryDto foodCategoryDto = new FoodCategoryDto();
//		foodCategoryDto.setCategoryId(foodCategory.getCategoryId());
		foodCategoryDto.setCategoryDiscription(foodCategory.getCategoryDiscription());
		foodCategoryDto.setFoodCategory(foodCategory.getFoodCategory());
		ItemsDto itemDto=new ItemsDto();
		itemDto.setId(getItem.getId());
		itemDto.setItemName(getItem.getItemName());
		itemDto.setPrice(getItem.getPrice());
		itemDto.setFoodCategoryDto(foodCategoryDto);
		
		return itemDto;
	}

	public MenuDto getMenuByRestaurantId(Integer restaurantId) {

        Menu getMenu=menuRepository.findByRestaurantId(restaurantId).get();
		Integer menuId=getMenu.getMenuid();
		List<Items> items= itemsRepo.findAllByMenuid(menuId);
		List<ItemsDto> itemList=items.stream().map(getItem->chnageitemslistToDtoList(getItem)).collect(Collectors.toList());
		MenuDto menuDto=new MenuDto();
		menuDto.setMenuid(getMenu.getMenuid());
		menuDto.setMenuDiscription(getMenu.getMenuDiscription());
		menuDto.setItems(itemList);
		return menuDto;
	}

	public ItemsDto getItemWithMenuIdAndItemId(Integer menuId, Integer itemId) {
		
		Items getItem=itemsRepo.findByMenuIdAndRestaurantId(menuId,itemId);
		FoodCategory foodCategory=getItem.getFoodCategory();
		FoodCategoryDto foodCategoryDto =modelMapper.map(foodCategory, FoodCategoryDto.class);
		ItemsDto itemDto=new ItemsDto();
		itemDto.setId(getItem.getId());
		itemDto.setItemName(getItem.getItemName());
		itemDto.setPrice(getItem.getPrice());
		itemDto.setFoodCategoryDto(foodCategoryDto);
		return itemDto;
	}

	public List<ItemsDto> addListOfItems(List<ItemsDto> itemdto, Integer menuId, Integer foodCategory) {
		
		List<ItemsDto> itemsListDto=itemdto.stream().map(oneItem->saveToDb(oneItem,menuId,foodCategory)).collect(Collectors.toList());
		return itemsListDto;
	}

	private ItemsDto saveToDb(ItemsDto oneItem, Integer menuId, Integer foodCategory) {

//		Items dtoToItem=modelMapper.map(oneItem, Items.class);
//		
//		Items item=itemsRepo.save(dtoToItem);
//		ItemsDto itemDto=modelMapper.map(item, ItemsDto.class);
//		return itemDto;
		Menu getMenu=menuRepository.findById(menuId).get();
		FoodCategory getCategory=foodCategoryRepo.findById(foodCategory).get();
		FoodCategoryDto categoryDto =modelMapper.map(getCategory, FoodCategoryDto.class);
		Items savedItems = new Items();
		savedItems.setItemName(oneItem.getItemName());
		savedItems.setPrice(oneItem.getPrice());
		savedItems.setFoodCategory(getCategory);
		savedItems.setMenu(getMenu);
		Items savedToDb=itemsRepo.save(savedItems);
		ItemsDto returnItme =new ItemsDto();
		returnItme.setId(savedToDb.getId());
		returnItme.setItemName(savedToDb.getItemName());
		returnItme.setPrice(savedToDb.getPrice());
		returnItme.setFoodCategoryDto(categoryDto);
		return returnItme;
	}

	public List<ItemsDto> getItemsList() {
		List<Items> itemsList=itemsRepo.findAll();
		List<ItemsDto> itemsListDto=itemsList.stream().map(oneItem->itemsToDto(oneItem)).collect(Collectors.toList());
		return itemsListDto;
	}

	private ItemsDto itemsToDto(Items oneItem) {

		ItemsDto itemDto=new ItemsDto();
		itemDto.setId(oneItem.getId());
		itemDto.setItemName(oneItem.getItemName());
		itemDto.setPrice(oneItem.getPrice());
		FoodCategoryDto foodCategoryDto=modelMapper.map(itemDto.getFoodCategoryDto().getCategoryId(), FoodCategoryDto.class);
		itemDto.setFoodCategoryDto(foodCategoryDto);
		return itemDto;
	}

}




















