package com.restaurant.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="order_data")
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	private int userId;
	
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="orderId_FK",referencedColumnName = "orderId")
	private List<Items> items;
	
}
