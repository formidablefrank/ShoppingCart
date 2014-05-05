package com.orangeandbronze.jbc.shoppingcart.model;

import java.math.BigDecimal;

public class Product {
	private String name;
	private BigDecimal price;
	private int productNo;
	
	
	public Product(String name, BigDecimal price, int productNo) {
		this.name = name;
		this.price = price;
		this.productNo = productNo;
	}
	//a domain model should determine what should it know or not
	//there are product that have no concept of quantity!
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + productNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productNo != other.productNo)
			return false;
		return true;
	}
	
}
