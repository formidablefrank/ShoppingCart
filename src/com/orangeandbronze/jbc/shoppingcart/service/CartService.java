package com.orangeandbronze.jbc.shoppingcart.service;

import java.math.BigDecimal;

import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoException;

public interface CartService {
	String showList(String name);
	BigDecimal getGrandTotal();
	void update() throws CartServiceDaoException;
	String buy(int productNumber, int quantity) throws CartServiceException, CartServiceDaoException;
	boolean allProductsZero();
}
