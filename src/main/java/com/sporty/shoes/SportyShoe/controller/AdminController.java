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

import com.sporty.shoes.SportyShoe.model.Category;
import com.sporty.shoes.SportyShoe.model.Product;
import com.sporty.shoes.SportyShoe.model.User;
import com.sporty.shoes.SportyShoe.service.ShoeService;

//import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

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
	public String registrationUser(@ModelAttribute User user) {
		if (user != null) {
			shoeService.saveUser(user);
			return "registered successfully";
		} else
			return "error in registration";
	}

	@GetMapping("loginUser")
	public ModelAndView registrationUser(@RequestParam String name, @RequestParam String password) {
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
	public String chngePw(@RequestParam String name, @RequestParam String password, @RequestParam String password1) {
		if (name != null && password != null && password1 != null && password.equals(password1)) {
			User u = shoeService.chngePw(name, password);

			if (u != null) {
				return "password changed";
			} else
				return "error";
		}
		return "error";
	}

	@RequestMapping("/userlist")
	public List<User> getUsers() {
		return shoeService.getUsers();
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
	public void deleteCCategory(@PathVariable int c,HttpServletResponse response) throws IOException {

		shoeService.deleteCategory(c);

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

//	@GetMapping("/products")
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
		System.out.println(product);
		Product product1 = shoeService.saveProduct(product);
		if (product1 != null) {
			response.sendRedirect("/category");

		}
		
	}

	@PostMapping("/DeleteProduct/{c}")
	public void deleteProuct(@PathVariable int c,HttpServletResponse response) throws IOException {

		shoeService.deleteProduct(c);

		response.sendRedirect("/category");

	}

	@GetMapping("/product/{pid}")
	public ModelAndView getProduct(@PathVariable int pid)

	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productForCart");
//		mv.addObject("product", shoeService.getProductByCategory(pid));
		return mv;
		
	}
	
	
	@PostMapping("addToCart/{pi}") 
	public void addToCart(@PathVariable int pi ,@RequestParam String size, @RequestParam int quantity,@RequestParam int uid, HttpServletResponse response) throws IOException
	{
		shoeService.addProductToCart(pi,size,quantity,uid);
		response.sendRedirect("/");
		
	}
}
