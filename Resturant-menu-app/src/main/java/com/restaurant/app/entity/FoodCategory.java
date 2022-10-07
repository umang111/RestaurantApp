package com.restaurant.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="food_category")
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategory {

	@Id
	@GeneratedValue
	private int categoryid;
	private String type;
	
	@OneToMany(mappedBy = "foodCategory")
	private List<Items> items;
}
