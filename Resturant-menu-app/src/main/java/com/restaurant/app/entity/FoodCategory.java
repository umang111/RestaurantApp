package com.restaurant.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="food_category")
@NoArgsConstructor
public class FoodCategory {

	@Id
	@GeneratedValue
	private int categoryId;
	private String foodCategory;
	private String categoryDiscription;
	
	@OneToMany(mappedBy = "foodCategory")
	private List<Items> items;
}
