package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.app.entity.Menu;

@Repository
public interface MenuRepository  extends JpaRepository<Menu,Integer>{

	Menu findByRestaurantId(Integer restaurantId);

	
}
