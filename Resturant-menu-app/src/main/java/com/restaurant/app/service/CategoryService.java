package com.restaurant.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.FoodCategoryDto;
import com.restaurant.app.entity.FoodCategory;
import com.restaurant.app.repository.FoodCategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private FoodCategoryRepo foodCategoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	public FoodCategoryDto addCategory(FoodCategoryDto foodCategoryDto) {
		FoodCategory savedCategory = modelMapper.map(foodCategoryDto, FoodCategory.class);
		foodCategoryRepo.save(savedCategory);
		FoodCategoryDto saveddto=modelMapper.map(savedCategory, FoodCategoryDto.class);
		return saveddto;
	}

	public FoodCategoryDto getCategoryById(Integer categoryId) {

		FoodCategory foodCategory=foodCategoryRepo.findById(categoryId).get();
		FoodCategoryDto foodCategoryDto=modelMapper.map(foodCategory, FoodCategoryDto.class);
		return foodCategoryDto;
	}

	public FoodCategoryDto updateCategoryById(Integer categoryId, FoodCategoryDto foodCategoryDto) {
		FoodCategory foodCategory=foodCategoryRepo.findById(categoryId).get();
		foodCategory.setFoodCategory(foodCategoryDto.getFoodCategory());
		foodCategory.setCategoryDiscription(foodCategoryDto.getCategoryDiscription());
		foodCategoryRepo.save(foodCategory);
		FoodCategoryDto returnCategory=modelMapper.map(foodCategory, FoodCategoryDto.class);
		return returnCategory;
	}

	public void deleteCategory(Integer categoryId) {
		
		foodCategoryRepo.deleteById(categoryId);
	}
	
}
