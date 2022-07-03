package com.sporty.shoes.SportyShoe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoes.SportyShoe.model.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String cte);

}

