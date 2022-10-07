package com.restaurant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
