package com.sporty.shoes.SportyShoe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoes.SportyShoe.model.Purchase;
import com.sporty.shoes.SportyShoe.model.User;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {

	public List<Purchase>    findAllByUserId(User u);
}
