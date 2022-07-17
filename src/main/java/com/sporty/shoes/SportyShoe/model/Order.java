package com.sporty.shoes.SportyShoe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Entity
@Table(name="OrderDetails")
public class Order {

	@Id
	@GeneratedValue
	
	private int orderId;
	@JoinTable(name="order_product",
		joinColumns = @JoinColumn(name="order_id"),
		inverseJoinColumns= @JoinColumn(name="product_id")
	    
			)
	@ManyToMany
	private List<Product> product = new ArrayList<>() ;
	
	private String status;
	
	private double totalPrice;
	@OneToOne
	
	private User user;
	@UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
	private Date orderDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProuct() {
		return product;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void addProduct(Product product) {
		this.getProduct().add(product);
	}
	
	public void removeProduct(Product product) {
		this.getProduct().remove(product);
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	

	
	
	
	
	
}
