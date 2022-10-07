package com.restaurant.app.feignClientUser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service", url="http://localhost:8093")
public interface UserFeignClient {
	
	@GetMapping("/getUser/{userId}")
	public UserDto getUser(@PathVariable("userId") Integer userId);

}
