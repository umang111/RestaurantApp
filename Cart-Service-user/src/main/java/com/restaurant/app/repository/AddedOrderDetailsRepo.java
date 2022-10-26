package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.AddedOrderDetails;

public interface AddedOrderDetailsRepo extends JpaRepository<AddedOrderDetails, Integer>{

}
