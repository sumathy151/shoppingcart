package com.mindtree.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.model.ProductDetails;


@Repository
public interface ProductRepository extends JpaRepository<ProductDetails,Integer> {

	public Object findById(int id);

	public List<Object> findByProductName(String name);
	
}
