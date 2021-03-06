package com.sporty.shoes.SportyShoe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoes.SportyShoe.model.Order;
import com.sporty.shoes.SportyShoe.model.User;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	
	public Order findByUserAndStatus(User user,String status);
}
