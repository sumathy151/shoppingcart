package com.mindtree.shoppingcart.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CART_ITEM")
public class CartDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartItemId;
	private int userId;
	private int quantity;
	
	@Transient
	private int productId;

	@Transient
	private double totalPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private ProductDetails productDetails;



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the cartItemId
	 */
	public int getCartItemId() {
		return cartItemId;
	}

	/**
	 * @param cartItemId the cartItemId to set
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the productDetails
	 */
	public ProductDetails getProductDetails() {
		return productDetails;
	}

	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartDetails [cartItemId=" + cartItemId + ", userId=" + userId + ", quantity=" + quantity
				+ ", productId=" + productId + ", totalPrice=" + totalPrice + ", productDetails=" + productDetails
				+ "]";
	}

	
	

}
