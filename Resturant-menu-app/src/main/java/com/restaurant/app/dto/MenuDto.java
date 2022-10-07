package com.restaurant.app.dto;

import java.util.List;

import com.restaurant.app.entity.Items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

	private int id;
	private int restaurantId;
	private List<ItemsDto> items;

}
