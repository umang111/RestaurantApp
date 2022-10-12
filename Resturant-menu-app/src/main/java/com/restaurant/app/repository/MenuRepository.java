package com.restaurant.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.app.entity.Menu;

@Repository
public interface MenuRepository  extends JpaRepository<Menu,Integer>{

	Optional<Menu> findByRestaurantId(Integer restaurantId);

//	Menu findByRestaurantId(Integer restaurantId);

	
}
