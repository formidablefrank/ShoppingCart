package com.orangeandbronze.jbc.shoppingcart.dao;

import java.util.Map;

import com.orangeandbronze.jbc.shoppingcart.model.Product;
import com.orangeandbronze.jbc.shoppingcart.model.ProductCollection;

public interface CartServiceDao {
	ProductCollection getList(String filename) throws CartServiceDaoException;
	void updateList(Map<Product, Integer> cart, String filename)
			throws CartServiceDaoException;
}
