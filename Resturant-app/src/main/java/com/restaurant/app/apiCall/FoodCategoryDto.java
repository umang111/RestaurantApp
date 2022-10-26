package com.restaurant.app.apiCall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto {

	private int categoryId;
	private String foodCategory;
	private String categoryDiscription;
}
