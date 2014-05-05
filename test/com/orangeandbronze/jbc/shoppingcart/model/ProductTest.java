package com.orangeandbronze.jbc.shoppingcart.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testEquals() {
		Product actualProduct = new Product("Foo", new BigDecimal("10.00"), 10);
		assertEquals(new Product("Foo", new BigDecimal("10.00"), 10), actualProduct);
		assertNotEquals(new Product("Food", new BigDecimal("1.00"), 11), actualProduct);
	}
	
	@Test
	public void testHashCode() {
		Product actualProduct = new Product("Foo", new BigDecimal("10.00"), 10);
		assertEquals(new Product("Foo", new BigDecimal("10.00"), 10).hashCode(), actualProduct.hashCode());
		assertNotEquals(new Product("Food", new BigDecimal("1.00"), 11).hashCode(), actualProduct.hashCode());
	}
	
}
