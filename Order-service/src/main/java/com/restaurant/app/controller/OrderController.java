package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.app.dto.OrderDetailsForCartService;
import com.restaurant.app.dto.OrderDto;
import com.restaurant.app.entity.Order;
import com.restaurant.app.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrder/{userId}/{menuId}")
	public Order addOrder(@PathVariable("userId") Integer userId, @PathVariable("menuId") Integer menuId,@RequestBody OrderDto orderDto) {
		Order order=orderService.addOrder(userId,menuId,orderDto);
		return order;
	}
	
	@GetMapping("/getOrderDetail/{orderId}")
	public Order getOrderDetails(@PathVariable("orderId") Integer orderId) {
		
		Order getOrder=orderService.findOrderById(orderId);
		return getOrder;
	}
	
	@GetMapping("/ordeDetailsForCart/{orderId}")
	public OrderDetailsForCartService ordeDetailsForCart(@PathVariable("orderId") Integer orderId) {
		OrderDetailsForCartService details=orderService.OrderDetailsForCartService(orderId);
		return details;
	}
}
