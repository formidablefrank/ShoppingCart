package com.orangeandbronze.jbc.shoppingcart.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.orangeandbronze.jbc.shoppingcart.model.Product;
import com.orangeandbronze.jbc.shoppingcart.model.ProductCollection;

public class CartServiceDaoImpl implements CartServiceDao {
	/*
	 * Data Layer.
	 * Reads the products in inventory and cart from their respective files
	 * Updates the files when it is necessary
	 */
	
	@Override
	public ProductCollection getList(String filename) throws CartServiceDaoException{
		Map<Product, Integer> list = new LinkedHashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
			int productNo = 1;
			while(reader.ready()){
				String temp[] = reader.readLine().split("\\s+");
				Product newProduct = new Product(temp[0], new BigDecimal(temp[2]), productNo++);
				list.put(newProduct, Integer.parseInt(temp[1]));
			}
		} catch(IOException e){
			throw new CartServiceDaoException("ERROR: Reading file failed");
		}
		return new ProductCollection(list);
	}

	@Override
	public void updateList(Map<Product, Integer> cart, String filename) throws CartServiceDaoException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
			for(Product pro: cart.keySet()){
				String temp = String.format("%s\t%d\t%s", pro.getName(), cart.get(pro), pro.getPrice().toPlainString());
				writer.write(temp);
				writer.newLine();
			}
		} catch (IOException e){
			throw new CartServiceDaoException("ERROR: Writing file failed");
		}
	}

}
