package com.orangeandbronze.jbc.shoppingcart.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDao;
import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoException;
import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoImpl;
import com.orangeandbronze.jbc.shoppingcart.model.Product;
import com.orangeandbronze.jbc.shoppingcart.model.ProductCollection;

public class CartServiceDaoImplTest {
	private final String PRODUCTS_FILE = "resources/products";
	private final String CART_FILE = "resources/cart";
	
	@Test
	public void testGetProducts() {
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 1);
		Product testProduct2 = new Product("Banana", new BigDecimal("8.00"), 2);
		Product testProduct3 = new Product("Bar", new BigDecimal("5.00"), 3);
		
		HashMap<Product, Integer> test = new HashMap<Product, Integer>();
		test.put(testProduct1, 13);
		test.put(testProduct2, 17);
		test.put(testProduct3, 10);
		ProductCollection testProducts = new ProductCollection(test);
		CartServiceDao cartServiceDao = new CartServiceDaoImpl();
		ProductCollection expectedProducts = null;
		try {
			expectedProducts = cartServiceDao.getList(PRODUCTS_FILE);
		} catch (CartServiceDaoException e) {
			System.out.println(e.getMessage());
		}
		
		assertEquals(expectedProducts, testProducts);
	}
	
	@Test
	public void testGetCart(){
		
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 5);
		Product testProduct2 = new Product("Bar", new BigDecimal("5.00"), 2);
		
		HashMap<Product, Integer> test = new HashMap<Product, Integer>();
		test.put(testProduct1, 2);
		test.put(testProduct2, 3);
		ProductCollection expectedCart = new ProductCollection(test);
		ProductCollection actualCart = null;
		CartServiceDao testCartService = new CartServiceDaoImpl();
		try {
			actualCart = testCartService.getList(CART_FILE);
		} catch (CartServiceDaoException e) {
			System.out.println(e.getMessage());
		}
		
		assertEquals(expectedCart, actualCart);
	}

}