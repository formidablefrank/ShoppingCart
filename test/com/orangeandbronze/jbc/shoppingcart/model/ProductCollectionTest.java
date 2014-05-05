package com.orangeandbronze.jbc.shoppingcart.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

public class ProductCollectionTest {

	@Test
	public void testGetGrandTotal() {
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 1);
		Product testProduct2 = new Product("Banana", new BigDecimal("8.00"), 2);
		Product testProduct3 = new Product("Bar", new BigDecimal("5.00"), 3);
		
		HashMap<Product, Integer> test = new HashMap<Product, Integer>();
		test.put(testProduct1, 1);
		test.put(testProduct2, 2);
		test.put(testProduct3, 3);
		ProductCollection testCart = new ProductCollection(test);
		assertEquals(new BigDecimal("41.00"), testCart.getGrandTotal());
	}
	
	@Test
	public void testGetQuantity(){
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 1);
		Product testProduct2 = new Product("Banana", new BigDecimal("8.00"), 2);
		Product testProduct3 = new Product("Bar", new BigDecimal("5.00"), 3);
		
		HashMap<Product, Integer> test = new HashMap<Product, Integer>();
		test.put(testProduct1, 1);
		test.put(testProduct2, 2);
		test.put(testProduct3, 3);
		ProductCollection testCart = new ProductCollection(test);
		assertEquals(6, testCart.getTotalQuantity());
	}

	@Test
	public void testAddProduct(){
		Product product = new Product("Foo", new BigDecimal("10.00"), 1);
		HashMap<Product, Integer> test = new HashMap<>();
		ProductCollection testCollection = new ProductCollection(test);
		testCollection.addProduct(product, 2);
	}
}
