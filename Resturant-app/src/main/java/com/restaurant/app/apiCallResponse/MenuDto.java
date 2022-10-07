package com.restaurant.app.apiCallResponse;

import java.util.List;

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
