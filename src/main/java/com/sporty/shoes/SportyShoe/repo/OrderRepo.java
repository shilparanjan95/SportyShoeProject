package com.sporty.shoes.SportyShoe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoes.SportyShoe.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
