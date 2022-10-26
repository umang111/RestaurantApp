package com.restaurant.app.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {

	private int cartId;
	private int userId;
	
	private List<AddedOrderDetailsDto> addedOrderDetailsDto;
}
