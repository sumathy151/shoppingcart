/**
 * 
 */
package com.mindtree.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.model.CartDetails;


/**
 * @author Sumathy
 *
 */

@Repository
public interface ShoppingCartRepository extends JpaRepository<CartDetails,Integer> 
{

	@Transactional
	@Modifying
	@Query(value = "update cart_item set quantity=?1 where cart_item_id=?2", nativeQuery = true)
	public void save(int quantity,int cartItemId);
	
	
	@Transactional
	@Modifying
	@Query(value="delete from cart_item where cart_item_id=?1",nativeQuery=true)
	public void deleteById(int cartItemId);

	public List<CartDetails> findByUserId(int userId);
	
	@Transactional
	@Modifying
	@Query(value="insert into cart_item(quantity,user_id,product_id,cart_item_id) values(?1,?2,?3,select nextval ('hibernate_sequence'))",nativeQuery=true)
	public void saveByProduct(int quantity,int user_id, int productId);


	
	@Transactional
	@Modifying
	@Query(value="delete from cart_item where user_id=?1",nativeQuery=true)
	public void deleteAllItemsFromCart(int userId);
	

	
}
