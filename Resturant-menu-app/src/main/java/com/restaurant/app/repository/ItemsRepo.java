
package com.restaurant.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.app.entity.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer>{


	@Query("select s from Items s where menu.menuid=:menuId and itemId=:itemId")
	Items findItem(@Param("menuId") Integer menuId,@Param("itemId") Integer itemId);

	@Query("select s from Items s where menu.menuid=?1")
	List<Items> findByMenuid(Integer menuId);

	@Query("select s from Items s where menu.menuid=?1")
	List<Items> findAllByMenuid(Integer menuId);

	@Query("select s from Items s where menu.menuid=:menuId and id=:itemId ")
	Items findByMenuIdAndRestaurantId(@Param("menuId")Integer menuId, @Param("itemId")Integer restaurantId);

}
