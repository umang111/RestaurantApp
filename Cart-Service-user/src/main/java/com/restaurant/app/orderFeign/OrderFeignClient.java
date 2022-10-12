package com.restaurant.app.orderFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="order-service",url="http://localhost:8094")
public interface OrderFeignClient {

	@GetMapping("/ordeDetailsForCart/{orderId}")
	public OrderDetailsForCartService ordeDetailsForCart(@PathVariable("orderId") Integer orderId);
}
