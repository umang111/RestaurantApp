package com.restaurant.app.feignClientUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String firstname;
	private String lastName;
	private String userMail;
	private String mobile;
	
//	feign
}
