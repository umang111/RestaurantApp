package com.restaurant.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer>{

	void save(List<Items> items);


}
