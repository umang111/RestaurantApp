package com.restaurant.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="items")
@NoArgsConstructor
public class Items {

	@Id
	@GeneratedValue
	@Column(name="new_item_id")
	private int newItemId;
	
	private int itemId;
	private String itemName;
	private String price;
	private int itemQuantity;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="orderId_fk",referencedColumnName = "order_id")
//	private Order order;
	
}
