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
	
}
