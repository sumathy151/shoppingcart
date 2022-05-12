package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mindtree.shoppingcart.model.ApparelDetails;


@Repository
public interface ApparelRepository extends JpaRepository<ApparelDetails,Integer> {
	

}
