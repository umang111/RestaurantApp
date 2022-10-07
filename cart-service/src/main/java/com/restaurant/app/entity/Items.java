package com.restaurant.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="items")
@NoArgsConstructor
public class Items {

	@Id
	private int itemId;
	private String itemName;
	private int itemPrice;
	
	@ManyToOne
	private Order order;
	
}
