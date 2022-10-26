package com.restaurant.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.AddedOrderDetailsDto;
import com.restaurant.app.dto.CartDto;
import com.restaurant.app.entity.AddedOrderDetails;
import com.restaurant.app.entity.Cart;
import com.restaurant.app.orderFeign.OrderDetailsForCartService;
import com.restaurant.app.orderFeign.OrderFeignClient;
import com.restaurant.app.repository.AddedOrderDetailsRepo;
import com.restaurant.app.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private OrderFeignClient oreFeignClient;
	
	@Autowired
	private AddedOrderDetailsRepo addedOrderRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Cart createCart(Integer userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		Cart savedCart= cartRepo.save(cart);
		return savedCart;
	}
	
	public AddedOrderDetailsDto addOrderTocart(Integer userId, Integer cartId, Integer orderId) throws Exception {
		
		OrderDetailsForCartService orderDetails= oreFeignClient.ordeDetailsForCart(orderId);
		if(orderId!=orderDetails.getOrderId()) {
			throw new Exception(" Order not found");
		}
		Cart cart =cartRepo.findById(cartId).get();
		AddedOrderDetails addedOrderDetails=new AddedOrderDetails();
		addedOrderDetails.setOrderId(orderId);
		addedOrderDetails.setCart(cart);
		addedOrderRepo.save(addedOrderDetails);
		return modelMapper.map(addedOrderDetails,AddedOrderDetailsDto.class);
	}

	public CartDto getCart(Integer userId) {

		Cart cart=cartRepo.findByUserId(userId);
		List<AddedOrderDetailsDto>  addedOrderRepo=cart.getAddOrderDetails().stream().map(oneItems->modelMapper.map(oneItems, AddedOrderDetailsDto.class)).collect(Collectors.toList());
		CartDto cartDto=modelMapper.map(cart, CartDto.class);
		cartDto.setAddedOrderDetailsDto(addedOrderRepo);
		return cartDto;
	}
}














