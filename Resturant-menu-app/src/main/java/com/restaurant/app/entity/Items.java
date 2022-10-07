package com.restaurant.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Items")
@AllArgsConstructor
@NoArgsConstructor
public class Items {

	@Id
	@GeneratedValue
	@Column(name="item_value")
	private int id;
	
	private String itemName;
	private String price;
	private int categoryId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FoodCategory foodCategory;
	
}
