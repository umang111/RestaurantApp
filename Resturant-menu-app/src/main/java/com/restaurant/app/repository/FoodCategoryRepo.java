package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.FoodCategory;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory, Integer>{

}
