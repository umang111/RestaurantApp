package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.app.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
