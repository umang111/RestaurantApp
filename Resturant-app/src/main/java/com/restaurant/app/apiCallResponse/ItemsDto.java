package com.restaurant.app.apiCallResponse;

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
	private int categoryId;
	
	private FoodCategoryDto foodCategoryDto;
}
