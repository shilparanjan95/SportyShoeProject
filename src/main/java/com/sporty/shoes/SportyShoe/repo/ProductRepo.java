package com.sporty.shoes.SportyShoe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category cs);

}
