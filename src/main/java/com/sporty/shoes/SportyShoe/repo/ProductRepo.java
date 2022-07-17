package com.sporty.shoes.SportyShoe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
   @Query(nativeQuery=true, value="select * from product where is_visible=1 and category_id = :cid")
	List<Product> findAllByCategoryAndIsVisible(@Param("cid")   int cid);

List<Product> findAllByIsVisible(boolean b);

}
