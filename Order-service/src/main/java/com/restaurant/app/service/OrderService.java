package com.restaurant.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.app.dto.ItemsDtoC;
import com.restaurant.app.dto.OrderDetailsForCartService;
import com.restaurant.app.dto.OrderDto;
import com.restaurant.app.entity.Items;
import com.restaurant.app.entity.Order;
import com.restaurant.app.feignMenuService.ItemsDto;
import com.restaurant.app.feignMenuService.MenuServiceClient;
import com.restaurant.app.repository.ItemsRepo;
import com.restaurant.app.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private MenuServiceClient menuServiceClient;
	
	@Autowired
	private ItemsRepo itemsRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	public Order addOrder(Integer userId,Integer menuId, OrderDto orderDto) {
		
		Order order=new Order();
		List<ItemsDtoC> itemDto=orderDto.getItems();
		order.setUserId(userId);
		//we can validate User by using user service
		List<Items> items=itemDto.stream().map(oneItem->setItemDetails(menuId,oneItem)).collect(Collectors.toList());
		order.setItems(items);
		Order savedOrder=orderRepo.save(order);
		return savedOrder;
	}

	private Items setItemDetails(Integer menuId, ItemsDtoC oneItem) {
		Items item=new Items();
		ItemsDto FitemDto=menuServiceClient.getItemWithMenuIdandRestaurantId(menuId, oneItem.getItemId());
		item.setItemId(FitemDto.getId());
		item.setItemName(FitemDto.getItemName());
		item.setPrice(FitemDto.getPrice());
		item.setItemQuantity(oneItem.getItemQuantity());
		return item;
	}

	public Order findOrderById(Integer orderId) {
		
		Order getOrder=orderRepo.findById(orderId).get();
		return getOrder;
	}

	public OrderDetailsForCartService OrderDetailsForCartService(Integer orderId) {

		Order getOrder=orderRepo.findById(orderId).get();
		OrderDetailsForCartService details= new OrderDetailsForCartService();
		details.setOrderId(getOrder.getOrderId());
		details.setUserId(getOrder.getUserId());
		return details;
	}

}
