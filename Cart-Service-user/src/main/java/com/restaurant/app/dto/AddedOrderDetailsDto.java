package com.restaurant.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddedOrderDetailsDto {

	private int orderId;	
	private CartDto cart;
}
