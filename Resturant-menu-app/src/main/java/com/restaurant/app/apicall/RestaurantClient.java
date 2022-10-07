package com.restaurant.app.apicall;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="Restaurant-app", url="http://localhost:8091/restaurant/getRestaurant/{restaurantId}")
public interface RestaurantClient {

}
