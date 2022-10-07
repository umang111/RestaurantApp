package com.restaurant.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="restaurant")
@NoArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue
	@Column(name="restauran_id")
	private int restaurantId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
}
