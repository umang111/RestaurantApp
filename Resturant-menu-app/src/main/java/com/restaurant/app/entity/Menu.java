package com.restaurant.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

	@Id
	@GeneratedValue
	@Column(name="menu_id")
	private int id;
	
	@Column(name="restaurant_id")
	private int restaurantId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id")
	private List<Items> items;
	
}
