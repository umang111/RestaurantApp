package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/category/{categoryId}")
	public FoodCategoryDto getCategory(@PathVariable("categoryId") Integer categoryId) {
		
		FoodCategoryDto foodCategoryDto=categoryService.getCategoryById(categoryId);
		return foodCategoryDto;
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public FoodCategoryDto updateCategory(@RequestBody FoodCategoryDto foodCategoryDto,@PathVariable("categoryId") Integer categoryId) {
		FoodCategoryDto returnCategory=categoryService.updateCategoryById(categoryId,foodCategoryDto);
		return returnCategory; 
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}











