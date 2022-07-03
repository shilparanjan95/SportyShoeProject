package com.sporty.shoes.SportyShoe.repo;

import com.sporty.shoes.SportyShoe.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public User findByNameAndPassword(String name,String password);
	public User findByName(String name);
	public List<User> findByType(String type);
}
