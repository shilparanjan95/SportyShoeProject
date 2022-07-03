package com.sporty.shoes.SportyShoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Order;
import com.sporty.shoes.SportyShoe.model.Product;
import com.sporty.shoes.SportyShoe.model.User;
import com.sporty.shoes.SportyShoe.repo.CategoryRepo;
import com.sporty.shoes.SportyShoe.repo.OrderRepo;
import com.sporty.shoes.SportyShoe.repo.ProductRepo;
import com.sporty.shoes.SportyShoe.repo.UserRepository;

@Service
public class ShoeServiceImpl implements ShoeService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;

	
	@Autowired
	private 	OrderRepo orderRepo;
	public User saveUser(User u) {

		return userRepository.save(u);
	}

	public Category saveCategory(Category c) {

		return categoryRepo.save(c);
	}

	@Override
	public User getUserDetail(String name, String password) {

		return userRepository.findByNameAndPassword(name, password);
	}

	@Override
	public User chngePw(String name, String password) {
		User u1 = null;
		User u = userRepository.findByName(name);
		if (u != null) {
			u.setPassword(password);
			u1 = userRepository.save(u);
		}
		return u1;
	}

	@Override
	public List<User> getUsers() {

		return userRepository.findByType("user");
	}

	@Override
	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}
	
	
	public void deleteCategory(int id)
	{
		categoryRepo.deleteById(id);
	}

	@Override
	public Category getCategory(int ct) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(ct).get()
				;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(int c) {
		productRepo.deleteById(c);
		
	}

	@Override
	public List<Product> getProductByCategory(int cte) {
		// TODO Auto-generated method stub
	Category	cs = categoryRepo.findById(cte).get();
		return  productRepo.findByCategory(cs);
	}

	@Override
	public void addProductToCart(int pi, String size, int quantity, int uid) {
		User user = userRepository.findById(uid).get();
		Product p = productRepo.findById(pi).get();
		p.setQuantity(quantity);
		p.setSize(size);
		Product p2 = productRepo.save(p);
		
		Order order = new Order();
		order.setProuct(p2);
		double tp = 0;
		for(Product p1 : order.getProuct())
		{
			tp= tp+p1.getPrice();
		}
		order.setTotalPrice(tp);
		order.setStatus("C");
		//order.setUser(user.getUserid());
		orderRepo.save(order);
	}

}
