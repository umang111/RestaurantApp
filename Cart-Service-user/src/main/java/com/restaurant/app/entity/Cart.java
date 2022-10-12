package com.restaurant.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	private int userId;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<AddedOrderDetails> addOrderDetails;
	
}
