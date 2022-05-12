package com.mindtree.shoppingcart.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductDetails {

	@Id
	private int productId;
	private String productName;
  
	private float price;
	
	@Transient
	private String category;
	
	@Transient
	private String searchKey;
	
	@Transient 
	private String searchOption;
	
	@OneToMany(mappedBy="productDetails",cascade=CascadeType.ALL)	
	private Collection<CartDetails> cartDetails = new ArrayList<CartDetails>();


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	

	
	public String getCategory() {
		return category;
	}

	
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * @param searchKey the searchKey to set
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * @return the searchOption
	 */
	public String getSearchOption() {
		return searchOption;
	}

	/**
	 * @param searchOption the searchOption to set
	 */
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	/**
	 * @return the cartDetails
	 */
	public Collection<CartDetails> getCartDetails() {
		return cartDetails;
	}

	/**
	 * @param cartDetails the cartDetails to set
	 */
	public void setCartDetails(Collection<CartDetails> cartDetails) {
		this.cartDetails = cartDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", category=" + category + ", searchKey=" + searchKey + ", searchOption=" + searchOption
				+ ", cartDetails=" + cartDetails + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	


	

}
