/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mindtree.shoppingcart.model.CartDetails;
import com.mindtree.shoppingcart.model.ProductDetails;
import com.mindtree.shoppingcart.service.ShoppingCartService;

/**
 * @author Sumathy
 *
 */
@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService cartService;

	@RequestMapping(value = "/shoppingCart/items", method = RequestMethod.GET)
	public String findAllItemsFromCart(Model model) {
		List<CartDetails> cartDetails = cartService.findAllItemsFromCart();
		model.addAttribute("cartDetails", cartDetails);

		return "cartPage";
	}

	@RequestMapping(value = "/shoppingCart/item/{productId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String addProductToCart(@PathVariable int productId, Model model, HttpServletRequest request)
	{

		HttpSession session = request.getSession(true);
		int userId = (int) session.getAttribute("userId");

		CartDetails cartDetails = new CartDetails();

		List<CartDetails> cartList = cartService.checkUserCart(userId);

		String viewPage = "";
		boolean isUpdated = false;
		if (CollectionUtils.isEmpty(cartList)) {

			// No cart for user yet. So treat this as a new item
			addToCart(productId, userId, cartDetails);
			viewPage = "searchPage";
		} else {
			for (CartDetails cart : cartList) {
				if (productId == cart.getProductDetails().getProductId()) {
					// product already exists in cart. So increment the quantity
					int newQty = cart.getQuantity() + 1;
					cart.setQuantity(newQty);
					cartService.updateCart(newQty, cart.getCartItemId());
					isUpdated = true;
					findAllItemsFromCart(model);
					viewPage = "cartPage";
				}
			}
			if (!isUpdated) {
				addToCart(productId, userId, cartDetails);
				viewPage = "searchPage";
			}
		}
		return viewPage;
	}

	/**
	 * @param productId
	 * @param userId
	 * @param cartDetails
	 */
	private void addToCart(int productId, int userId, CartDetails cartDetails) {
		ProductDetails pd = new ProductDetails();
		pd.setProductId(productId);
		cartDetails.setProductDetails(pd);
		cartDetails.setQuantity(1);
		cartDetails.setUserId(userId);
		cartService.addProductToCart(cartDetails);
	}

	@RequestMapping(value = "/shoppingCart/items/{cartItemId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteFromCart(@PathVariable("cartItemId") int cartItemId, Model model) {

		cartService.deleteItemFromCart(cartItemId);

		// To redisplay the cart after deleting the item.
		findAllItemsFromCart(model);

		return "cartPage";

	} 
	
	@RequestMapping(value="/shoppingCart/allItems",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteAllItemsFromCart(Model model,HttpServletRequest request)
	{
			HttpSession session = request.getSession(true);
			int userId = (int) session.getAttribute("userId");
		
				cartService.deleteAllItemsFromCart(userId);
				// To redisplay the cart after deleting the item.
				findAllItemsFromCart(model);
				return "cartPage";
	}
	

}

