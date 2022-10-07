package com.restaurant.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.FoodCategoryDto;
import com.restaurant.app.entity.FoodCategory;
import com.restaurant.app.repository.FoodCategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private FoodCategoryRepo foodCategoryRepo;

	public void addCategory(FoodCategoryDto foodCategoryDto) {
		FoodCategory savedCategory = new FoodCategory();
		savedCategory.setType(foodCategoryDto.getType());
		foodCategoryRepo.save(savedCategory);
	}
	
}
