
package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.app.entity.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer>{

}
