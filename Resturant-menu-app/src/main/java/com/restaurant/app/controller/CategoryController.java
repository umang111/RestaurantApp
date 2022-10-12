package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.FoodCategoryDto;
import com.restaurant.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addCategory")
	public FoodCategoryDto addCategory(@RequestBody FoodCategoryDto foodCategoryDto) {
		FoodCategoryDto savedCategory= categoryService.addCategory(foodCategoryDto);
		return savedCategory;
	}
}
