package com.mindtree.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="APPAREL")
public class ApparelDetails extends ProductDetails {
	
	
	private String type;
	private String brand;
	private String design;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	
	
	@Override
	public String toString() {
		return "ApparelDetails [type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}

}
