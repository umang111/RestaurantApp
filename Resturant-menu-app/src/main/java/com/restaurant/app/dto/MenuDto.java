package com.restaurant.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

	private int menuid;
	private String menuDiscription;
	private int restaurantId;
	private List<ItemsDto> items;

}
