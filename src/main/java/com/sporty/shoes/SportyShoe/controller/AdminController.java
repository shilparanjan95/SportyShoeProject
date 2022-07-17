package com.sporty.shoes.SportyShoe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*import com.sporty.shoes.SportyShoe.model.Address;
*/import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Order;
import com.sporty.shoes.SportyShoe.model.Product;
import com.sporty.shoes.SportyShoe.model.Purchase;
import com.sporty.shoes.SportyShoe.model.User;
import com.sporty.shoes.SportyShoe.service.ShoeService;

//import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
         int  count =0;
	@Autowired
	private ShoeService shoeService;

	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/")
	public ModelAndView registrationPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	@PostMapping("register")
	public ModelAndView registrationUser(@ModelAttribute User user,ModelAndView mv) {
		if (user != null) {
			shoeService.saveUser(user);
			mv.setViewName("login");
			mv.addObject("msg", "Registered Successfully");
		} else
			mv.setViewName("error");
		return mv;
	}

	@GetMapping("loginUser")
	public ModelAndView registrationUser(HttpSession session,@RequestParam String name, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();

		if (name != null && password != null) {
			User user = shoeService.getUserDetail(name, password);
			mv.addObject("user", user);
			if (user != null && user.getType().equals("admin")) {
				mv.setViewName("admin");
				mv.addObject("userCount", shoeService.getUsers().stream().count());
			} else {
				mv.setViewName("user");
				mv.addObject("category", shoeService.listCategories());
				mv.addObject("userId", user.getUserid());
				mv.addObject("message", null);
		 		//session.setAttribute("count", value);
		 		mv.addObject("count", 0);
			}
		} else {
			mv.setViewName("error");
		}
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView Logout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("msg", new String("You have been logged out"));
		mv.addObject("userId", 0);
		return mv;
	}

	@RequestMapping("/changepassword")
	public ModelAndView changePasword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pwd");
		// mv.addObject("msg", new String("You have been logged out"));
		return mv;
	}

	@PostMapping("/pwdUpdate")
	public ModelAndView chngePw(ModelAndView mv, @RequestParam String name, @RequestParam String password, @RequestParam String password1) {
		if (name != null && password != null && password1 != null && password.equals(password1)) {
			User u = shoeService.chngePw(name, password);

			if (u != null) {
				mv.addObject("msg", "Password Changed Successfully");
				mv.setViewName("login");
			} else
				mv.setViewName("error");
		}
		return mv;
	}

	@RequestMapping("/userlist")
	public ModelAndView getUsers(ModelAndView mv) {
		mv.setViewName("users");
		mv.addObject("users", shoeService.getUsers());
		return mv;
	}

	@GetMapping("/category")
	public ModelAndView getAllCategorie() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("category", shoeService.listCategories());
		mv.setViewName("category");
		return mv;

	}

	@GetMapping("/ct")
	public ModelAndView addCategorie() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("cte");
		return mv;

	}

	@PostMapping("/addCategory")
	public void addCategories(@ModelAttribute Category ct,HttpServletResponse response) throws IOException {
		
		Category c1 = shoeService.saveCategory(ct);
		if (c1 != null) {
		 response.sendRedirect("/category");
		}
		
		

	}

	@PostMapping("/category/{c}")
	public void deleteCCategory(@PathVariable int c,HttpServletResponse response, HttpSession session) throws IOException {

		shoeService.deleteCategory(c);
          System.out.println(session.getAttribute("user"));
		response.sendRedirect("/category");

	}

	@PostMapping("/edit/category")
	public ModelAndView editcategory(@RequestParam int ct) {
		ModelAndView mv = new ModelAndView();
		Category c = shoeService.getCategory(ct);
		mv.addObject("name", c);
		mv.setViewName("cte2");
		return mv;
	}

	@PostMapping("/editCategory")
	public void editCategory(@ModelAttribute Category ct,HttpServletResponse response) throws IOException {

		Category c1 = shoeService.saveCategory(ct);
		if (c1 != null) {
			response.sendRedirect("/category");
		}
		

	}

	@GetMapping("/products")
	public ModelAndView allProducts() {
		ModelAndView mv = new ModelAndView();
		List<Product> c = shoeService.getAllProduct();
		mv.addObject("product", c);
		mv.setViewName("product");
		return mv;
	}

	@GetMapping("/product")
	public ModelAndView aldProduct() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("category", shoeService.listCategories());
		mv.setViewName("addProduct");
		return mv;
	}

	@PostMapping("addProduct")
	public void addProduct(@ModelAttribute Product product,HttpServletResponse response) throws IOException {
		
		product.setIsVisible(true);
		System.out.println(product);
		Product product1 = shoeService.saveProduct(product);
		if (product1 != null) {
			response.sendRedirect("/products");

		}
		
	}

	@PostMapping("/DeleteProduct/{c}")
	public void deleteProuct(@PathVariable int c,HttpServletResponse response) throws IOException {

		shoeService.deleteProduct(c);

		response.sendRedirect("/products");

	}

	@GetMapping("/product/{cid}")
	public ModelAndView getProduct(@PathVariable("cid") int cid,HttpSession session)

	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productForCart");
		//mv.setViewName("user");
		mv.addObject("product", shoeService.getProductByCategory(cid));
		mv.addObject("category", shoeService.listCategories());
		mv.addObject("categoryId", cid);
		  mv.addObject("category", shoeService.listCategories());
        System.out.println(session.getAttribute("user"));
        mv.addObject("userId",((User) session.getAttribute("user")).getUserid());
		return mv;
		
	}
	
	
	@PostMapping("addToCart/{pi}") 
	public ModelAndView addToCart(HttpSession session, ModelAndView mv ,@PathVariable int pi , @RequestParam int cid ,@RequestParam String size, 
			@RequestParam int quantity,@RequestParam int uid, HttpServletResponse response) throws IOException
	{     
		 Product p = shoeService.getProduct(pi);
		
		/* mv.addObject("size", size);
		 mv.addObject("quantity", quantity);
       */Order order=  shoeService.addProductToCart(pi, size, quantity, uid);
/*		 mv.addObject("categoryId", cid);
*/		 mv.addObject("productx", shoeService.getProduct(pi));
         mv.addObject("order", order);
        // mv.setViewName("cart");
         mv.addObject("category", shoeService.listCategories());
         mv.setViewName("productForCart");
         mv.addObject("product", shoeService.getProductByCategory(p.getCategory().getId()));
 		mv.addObject("categoryId",p.getCategory().getId());
 		mv.addObject("message", "product added to cart");
 		mv.addObject("userId", uid);
 		count++;
 		mv.addObject("count", count);
 		session.setAttribute("count", count);
		return mv;
		 
			}
	@PostMapping("/edit/product/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid,ModelAndView mv)
	{   mv.addObject("product", shoeService.getProduct(pid));
	   List<Category> listCategories = shoeService.listCategories();
	    mv.addObject("category", listCategories);
		mv.setViewName("editProduct");
		return mv;
	}
	
	@PostMapping("/billing")
	public ModelAndView biilingOfOrder(@RequestParam("order") int orderId, ModelAndView mv ,HttpSession session,@RequestParam String username)
	{
		System.out.println("#########################################"+orderId);
		
		mv.addObject("order", orderId);
		mv.addObject("username", username);
		mv.setViewName("address");
		 System.out.println(session.getAttribute("user"));
	        mv.addObject("userId",((User) session.getAttribute("user")).getUserid());
		return mv;
	}
	
	@PostMapping("/checkout")
	public ModelAndView biilingOfOrder(@RequestParam int order,ModelAndView mv,HttpSession session)
	{
		System.out.println("#########################################"+order);
		Purchase p = shoeService.makePurchase(order);
		mv.addObject("p", p);
		mv.addObject("count", 0);
		session.setAttribute("count", 0);
		mv.addObject("message", null);
		 System.out.println(session.getAttribute("user"));
	        mv.addObject("userId",((User) session.getAttribute("user")).getUserid());
	    mv.setViewName("receipt");
	    return mv;
	}
	
	@GetMapping("/cart/{uid}")
	public ModelAndView toCartPage(@PathVariable("uid") int uid,ModelAndView mv)
	{
	
		Order order = shoeService.getAllOrdersForUser(uid);
		mv.setViewName("cart");
		mv.addObject("order" ,order);
	    mv.addObject("userId",uid);
		return mv;
		
	}
	@GetMapping("/orders/{userId}")
	public ModelAndView orderPage(@PathVariable("userId") int userId,ModelAndView mv)
	{
		
		List<Purchase> p = shoeService.getOrders(userId);
		
		mv.addObject("plist", p);
	
	    mv.setViewName("receipt1");
	    return mv;
	}
	@GetMapping("/reports")
	public ModelAndView getPurchaseReport(ModelAndView mv)
	{   List<Purchase> purchaseList = shoeService.getAllPurchases();
		mv.setViewName("purchaseReport");
		mv.addObject("purchase", purchaseList);
		return mv;
	}
	@PostMapping("/editProduct")
	public void editProduct(@ModelAttribute Product product,HttpServletResponse response) throws IOException {
		product.setIsVisible(true);
		Product product1 = shoeService.saveProduct(product);
		if (product1 != null) {
			response.sendRedirect("/products");

		}
	}
		@PostMapping("/deleteProduct/{pid}/{oid}/{uid}")
		public void  removeFromCart(HttpSession session,ModelAndView mv ,HttpServletResponse response,
				@PathVariable("pid") int pid, @PathVariable("oid") int oid,@PathVariable("uid") int uid) throws IOException
		{   int count= (int)session.getAttribute("count");
			
			if(count>0)
		{
			count =count--;
		}
			/*mv.addObject("count", count--);*/
			shoeService.removeProductFromCart(oid,pid);
			session.setAttribute("count", count);
			response.sendRedirect("/cart/"+uid);
			
		}

}
