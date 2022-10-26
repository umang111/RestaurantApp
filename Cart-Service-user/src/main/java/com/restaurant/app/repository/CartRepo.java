package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer> {

	Cart findByUserId(Integer userId);

}
