package com.sporty.shoes.SportyShoe.service;

import java.util.List;

import com.sporty.shoes.SportyShoe.model.*;

public interface ShoeService {

	
	
	public User saveUser(User user);
	public User getUserDetail(String name,String password);
	public User chngePw(String name, String password);
	public List<User> getUsers();
	public List<Category> listCategories();
	public Category saveCategory(Category c);
	public void deleteCategory(int id);
	public Category getCategory(int ct);
	public List<Product> getAllProduct();
	public Product saveProduct(Product product);
	public void deleteProduct(int c);
	public List<Product> getProductByCategory(int c);
	public void addProductToCart(int pi, String size, int quantity, int uid);

	
}
