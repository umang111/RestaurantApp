package com.restaurant.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.entity.AddedOrderDetails;
import com.restaurant.app.entity.Cart;
import com.restaurant.app.orderFeign.OrderDetailsForCartService;
import com.restaurant.app.orderFeign.OrderFeignClient;
import com.restaurant.app.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private OrderFeignClient oreFeignClient;
	
	public Cart createCart(Integer userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		Cart savedCart= cartRepo.save(cart);
		return savedCart;
	}
	
	public AddedOrderDetails addOrderTocart(Integer userId, Integer cartId, Integer orderId) throws Exception {
		
		OrderDetailsForCartService orderDetails= oreFeignClient.ordeDetailsForCart(orderId);
		if(orderId!=orderDetails.getOrderId()) {
			throw new Exception(" Order not found");
		}
		Cart cart =cartRepo.findById(cartId).get();
		AddedOrderDetails addedOrderDetails=new AddedOrderDetails();
		addedOrderDetails.setOrderId(orderId);
		addedOrderDetails.setCart(cart);
		return addedOrderDetails;
	}
}
