package com.orangeandbronze.jbc.shoppingcart.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoException;
import com.orangeandbronze.jbc.shoppingcart.model.Product;
import com.orangeandbronze.jbc.shoppingcart.model.ProductCollection;
import com.orangeandbronze.jbc.shoppingcart.service.CartService;
import com.orangeandbronze.jbc.shoppingcart.service.CartServiceException;
import com.orangeandbronze.jbc.shoppingcart.service.CartServiceImpl;

public class CartServiceImplTest {
	
	//@Test
	public void testBuy(){
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 10);
		Product testProduct2 = new Product("Banana", new BigDecimal("8.00"), 2);
		Product testProduct3 = new Product("Bar", new BigDecimal("5.00"), 3);
		
		HashMap<Product, Integer> testProducts = new HashMap<Product, Integer>();
		testProducts.put(testProduct1, 0);
		testProducts.put(testProduct2, 0);
		testProducts.put(testProduct3, 0);
		
		HashMap<Product, Integer> actualCart = new HashMap<Product, Integer>();
		
		CartService testCartService = null;
		try {
			testCartService = new CartServiceImpl();
			((CartServiceImpl) testCartService).setProducts(new ProductCollection(testProducts));
			((CartServiceImpl) testCartService).setCart(new ProductCollection(actualCart));
			int testProductNo = 1;
			int testQuantity = 2;
			testCartService.buy(testProductNo, testQuantity);
		} catch (CartServiceDaoException e) {
			System.out.println(e.getMessage());
		} catch (CartServiceException e) {
			System.out.println(e.getMessage());
		}
		
		List<Product> expectedCart = new ArrayList<Product>();
		expectedCart.add(new Product("Foo", new BigDecimal("10.00"), 2));
		
		assertEquals(expectedCart, actualCart);
	}
	
	@Test
	public void testAllProductsZero(){
		Product testProduct1 = new Product("Foo", new BigDecimal("10.00"), 1);
		Product testProduct2 = new Product("Banana", new BigDecimal("8.00"), 2);
		Product testProduct3 = new Product("Bar", new BigDecimal("5.00"), 3);
		
		HashMap<Product, Integer> test = new HashMap<Product, Integer>();
		test.put(testProduct1, 0);
		test.put(testProduct2, 0);
		test.put(testProduct3, 0);
		ProductCollection testCart = new ProductCollection(test);
		CartService testCartService = null;
		try {
			testCartService = new CartServiceImpl();
			((CartServiceImpl) testCartService).setCart(testCart);
		} catch (CartServiceDaoException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(testCartService.allProductsZero());
	}

}
