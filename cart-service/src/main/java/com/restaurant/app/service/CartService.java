package com.restaurant.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.CartDto;
import com.restaurant.app.dto.OrderDto;
import com.restaurant.app.dto.itemsDto;
import com.restaurant.app.entity.Items;
import com.restaurant.app.entity.Order;
import com.restaurant.app.entity.User;
import com.restaurant.app.feignClientUser.UserDto;
import com.restaurant.app.feignClientUser.UserFeignClient;
import com.restaurant.app.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserFeignClient userFeignClient;

	public void addTocart(Integer userId, Integer restaurantId, CartDto cart) {
		
		User user=getUserDetails(userId);
		List<Items> items=getOrderDetails(cart,restaurantId);
	}
	
	
	private User getUserDetails(Integer userId) {
		User user =new User();
		UserDto userDto=userFeignClient.getUser(userId);
		user.setFirstName(userDto.getFirstname());
		user.setLastName(userDto.getLastName());
		user.setMobile(userDto.getMobile());
		return user;
	}
	
	private List<Items> getOrderDetails(CartDto cart, Integer restaurantId) {

		OrderDto orderdto=cart.getOrder();
		List<itemsDto> items= orderdto.getItems();
		List<Items> itemList =items.stream().map(oneItem->setItemDetails(oneItem,restaurantId)).collect(Collectors.toList());
		return itemList;
	}


	private Items setItemDetails(itemsDto oneItem, Integer restaurantId) {

		return null;
	}
}
