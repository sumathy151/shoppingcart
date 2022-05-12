/**
 * 
 */
package com.mindtree.shoppingcart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.shoppingcart.model.CartDetails;
import com.mindtree.shoppingcart.repository.ShoppingCartRepository;

/**
 * @author Sumathy
 *
 */

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository cartRepository;

	public List<CartDetails> findAllItemsFromCart() {

		List<CartDetails> cartDetails = cartRepository.findAll();
		return cartDetails;

	}

	public void addProductToCart(CartDetails cartDetails) {

		int productId = cartDetails.getProductDetails().getProductId();
		int userId = cartDetails.getUserId();
		int quantity = cartDetails.getQuantity();
		cartRepository.saveByProduct(quantity, userId, productId);

	}

	public List<CartDetails> checkUserCart(int userId) {
		List<CartDetails> cartDetails = cartRepository.findByUserId(userId);
		return cartDetails;

	}

	public void updateCart(int quantity, int cartItemId) {
		cartRepository.save(quantity, cartItemId);

	}

	public void deleteItemFromCart(int cartItemId) {

		cartRepository.deleteById(cartItemId);
	}

	public void deleteAllItemsFromCart(int userId) {
		cartRepository.deleteAllItemsFromCart(userId);
	}

}
