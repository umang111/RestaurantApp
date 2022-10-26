package com.restaurant.app.orderFeign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsForCartService {

	private int orderId;
	private int userId;
}
