package com.restaurant.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
public class User {

	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String mobile;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
}
