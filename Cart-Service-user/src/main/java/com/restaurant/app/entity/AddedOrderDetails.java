package com.restaurant.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="user_orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AddedOrderDetails {

	@Id
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;
}
