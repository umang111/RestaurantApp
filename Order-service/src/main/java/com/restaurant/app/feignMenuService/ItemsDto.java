package com.restaurant.app.feignMenuService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDto {

	private int id;
	private String itemName;
	private String price;
	
	private FoodCategoryDto foodCategoryDto;
}
