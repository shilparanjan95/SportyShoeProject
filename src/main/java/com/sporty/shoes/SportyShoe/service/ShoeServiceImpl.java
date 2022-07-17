package com.sporty.shoes.SportyShoe.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Order;
import com.sporty.shoes.SportyShoe.model.Product;
import com.sporty.shoes.SportyShoe.model.Purchase;
import com.sporty.shoes.SportyShoe.model.User;
import com.sporty.shoes.SportyShoe.repo.CategoryRepo;
import com.sporty.shoes.SportyShoe.repo.OrderRepo;
import com.sporty.shoes.SportyShoe.repo.ProductRepo;
import com.sporty.shoes.SportyShoe.repo.PurchaseRepo;
import com.sporty.shoes.SportyShoe.repo.UserRepository;

@Service
public class ShoeServiceImpl implements ShoeService {
	@Autowired
    private PurchaseRepo purchaseRepo;
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
		
		return productRepo.findAllByIsVisible(true);
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
		//Category ct = categoryRepo.findById(cte).get();
		return  productRepo.findAllByCategoryAndIsVisible(cte);
	}

	@Override
	public Order addProductToCart(int pi, String size, int quantity, int uid) {
		
     Product p = productRepo.findById(pi).get();
     Product p1 = new Product();
     p1.setGender(p.getGender());
     p1.setCategory(p.getCategory());
     p1.setPrice(p.getPrice());
     p1.setQuantity(quantity);
	 p1.setSize(size);
	 p1.setIsVisible(false);
	 p1.setName(p.getName());
	 productRepo.save(p1);
	 User user = userRepository.findById(uid).get();
	 
	 Order o = orderRepo.findByUserAndStatus(user, "C");
	 if(o!=null) {
	 o.setUser(user);
	 o.addProduct(p1);
	 o.setStatus("C");
	 o.setTotalPrice(o.getTotalPrice()+(p1.getPrice()*quantity));
	 }
	 else
	 {
		 o = new Order();
		 o.setUser(user);
		 o.addProduct(p1);
		 o.setStatus("C");
		 o.setTotalPrice(p1.getPrice()*quantity);
	 }
	 
		return 	 orderRepo.save(o);

		
	}

	@Override
	public Product getProduct(int productid) {
		
		return productRepo.findById(productid).get();
	}

	@Override
	public Purchase makePurchase(int order) {
		
		Purchase p = new Purchase();
		
		Order order2 = orderRepo.findById(order).get();
		order2.setStatus("P");
		orderRepo.save(order2);
		p.setOrder(order2);
		p.setUserId(order2.getUser());
		
		return purchaseRepo.save(p);
	}

	@Override
	public Order getAllOrdersForUser(int userId) {
		// TODO Auto-generated method stub
		
		
		User user = userRepository.findById(userId).get();
		return orderRepo.findByUserAndStatus(user,"C");
	}

	@Override
	public List<Purchase> getOrders(int userId) {
		User user = userRepository.findById(userId).get();
         System.out.println(user);
		return purchaseRepo.findAllByUserId(user);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		// TODO Auto-generated method stub
		return purchaseRepo.findAll();
	}

	@Override
	public void removeProductFromCart(int oid, int pid) {
		// TODO Auto-generated method stub

		
		
		Order o = orderRepo.findById(oid).get();
		int productCount = o.getProduct().size();
		Product p = productRepo.findById(pid).get();
		
		if(productCount==1)
		{
			orderRepo.deleteById(oid);
			productRepo.deleteById(pid);
		}
		else
			
		{
		o.setTotalPrice(o.getTotalPrice()-(p.getPrice()*p.getQuantity()));
		o.removeProduct(p);
		orderRepo.save(o);
		productRepo.deleteById(pid);
	}
	
	
	
	}
}
