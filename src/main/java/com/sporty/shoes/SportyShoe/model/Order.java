package com.sporty.shoes.SportyShoe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="myOrer")
public class Order {

	@Id
	@GeneratedValue
	
	private int orderId;
	@OneToMany
	private List<Product> prouct = new ArrayList<>();
	
	private String status;
	
	private double totalPrice;
	@OneToOne
	
	private User user;
	/*@UpdateTimestamp*/
/*@Temporal(value = TemporalType.TIMESTAMP)
	private Date orderDate;
	*/
	/*@Embedded
	private Address  address;*/
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProuct() {
		return prouct;
	}
	public void setProuct(Product myprouct) {
		
		
		this.prouct.add(myprouct);
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
	/*public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}*/
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", prouct=" + prouct + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", user=" + user + "]";
	}	

	
	
	
	
	
}
