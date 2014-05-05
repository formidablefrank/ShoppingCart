package com.orangeandbronze.jbc.shoppingcart.model;

import java.math.BigDecimal;
import java.util.Map;

public class ProductCollection {
	private Map<Product, Integer> collection;
	private BigDecimal grandTotal;
	private int totalQuantity;
	
	public ProductCollection(Map<Product, Integer> collection){
		this.collection = collection;
	}

	public Map<Product, Integer> getCollection() {
		return collection;
	}

	public void setCollection(Map<Product, Integer> collection) {
		this.collection = collection;
	}

	public BigDecimal getGrandTotal() {
		BigDecimal total = new BigDecimal("0.00");
		for(Product pro: collection.keySet()){
			total = total.add(pro.getPrice().multiply(new BigDecimal(collection.get(pro))));
		}
		grandTotal = total;
		return grandTotal;
	}
	
	public Integer getQuantity(Product pro){
		return collection.get(pro);
	}
	
	public void setQuantity(Product pro, Integer value){
		collection.put(pro, value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((collection == null) ? 0 : collection.hashCode());
		result = prime * result
				+ ((grandTotal == null) ? 0 : grandTotal.hashCode());
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
		ProductCollection other = (ProductCollection) obj;
		if (collection == null) {
			if (other.collection != null)
				return false;
		} else if (!collection.equals(other.collection))
			return false;
		if (grandTotal == null) {
			if (other.grandTotal != null)
				return false;
		} else if (!grandTotal.equals(other.grandTotal))
			return false;
		return true;
	}

	public int getTotalQuantity() {
		int total = 0;
		for(Product pro: collection.keySet()){
			total += collection.get(pro);
		}
		totalQuantity = total;
		return totalQuantity;
	}
	
	public void addProduct(Product product, int quantity){
		Product temp = search(product);
		if(temp == null) {
			collection.put(product, quantity);
		} else {
			collection.put(temp, collection.get(temp) + quantity);
		}
	}
	
	public void removeProduct(Product product, int quantity){
		Product temp = search(product);
		collection.put(temp, collection.get(temp) - quantity);
	}
	
	public Product search(Product product){
		for(Product pro: collection.keySet()){
			if (pro.getName().equals(product.getName())){
				return pro;
			}
		}
		return null;
	}
}
