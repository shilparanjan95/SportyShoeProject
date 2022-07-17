package com.sporty.shoes.SportyShoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class Product {
	@Id
	@GeneratedValue
	
	private int id;
	@OneToOne
	private Category category;
	private String gender;
	private String name;
	private double price;
	private int quantity;
	private String size;
	@Column(columnDefinition = "bit default 1")
	private boolean isVisible;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	public boolean isIsVisible() {
		return isVisible;
	}
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", gender=" + gender + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + ", size=" + size + ", isVisible=" + isVisible + "]";
	}
	public Product() {
		
	}
 
}
