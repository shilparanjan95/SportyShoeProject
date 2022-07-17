package com.sporty.shoes.SportyShoe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Purchase {
	@Id
	@GeneratedValue
    private int purchaseId;
    
	@OneToOne
	private Order  order;
    /*@Embedded
	private  Address address;*/
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
    @OneToOne
    private User userId;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
    
    
    
    
    
	
}
