package com.orangeandbronze.jbc.shoppingcart.service;

import java.math.BigDecimal;

import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDao;
import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoException;
import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoImpl;
import com.orangeandbronze.jbc.shoppingcart.model.Product;
import com.orangeandbronze.jbc.shoppingcart.model.ProductCollection;

public class CartServiceImpl implements CartService {
	/*
	 * Service Layer.
	 * Sends the list of products in the inventory and in the cart (and grand total) to the presentation layer if requested 
	 * Does the purchasing via buy() method
	 */
	private CartServiceDao serviceDao;
	private ProductCollection cart;
	private ProductCollection products;
	private final String PRODUCTS_FILE = "resources/products";
	private final String CART_FILE = "resources/cart";
	
	public CartServiceImpl() throws CartServiceDaoException{
		serviceDao = new CartServiceDaoImpl();
		products = serviceDao.getList(PRODUCTS_FILE);
		cart = serviceDao.getList(CART_FILE);
	}
	
	
	public ProductCollection getProducts() {
		return products;
	}

	public void setProducts(ProductCollection products) {
		this.products = products;
	}

	public ProductCollection getCart() {
		return cart;
	}

	public void setCart(ProductCollection cart) {
		this.cart = cart;
	}

	@Override
	public BigDecimal getGrandTotal(){
		return cart.getGrandTotal();
	}

	@Override
	public String showList(String name) {
		String temp = "";
		ProductCollection list = (name.equals("products") ? products : cart);
		for (Product pro: list.getCollection().keySet()){
			temp += String.format("%d\t%s\t%s\t%d\n", pro.getProductNo(), pro.getName(), pro.getPrice().toPlainString(), list.getCollection().get(pro));
		}
		return temp;
	}

	@Override
	public String buy(int productNumber, int quantity) throws CartServiceException, CartServiceDaoException{
		if(quantity < 1){
			throw new CartServiceException("Invalid argument for quantity! Try again.");
		} else if (productNumber >= products.getCollection().size() && productNumber < 1) {
			throw new CartServiceException("Invalid argument for product number! Try again.");
		} else {
			//query first if the product has enough supply vs. customer's demand
			Product boughtProduct = null;
			for (Product pro: products.getCollection().keySet()){
				if(productNumber == pro.getProductNo())
					boughtProduct = pro;
			}
			if (products.getCollection().get(boughtProduct) < quantity) {
				throw new CartServiceException("Insufficient supply! Try again.");
			} else {
				products.removeProduct(boughtProduct, quantity);
				cart.addProduct(boughtProduct, quantity);
				update();
				return "Bought " + quantity + " pieces of " + boughtProduct.getName() + ".";
			}
		}
	}

	@Override
	public void update() throws CartServiceDaoException{
		serviceDao.updateList(products.getCollection(), PRODUCTS_FILE);
		serviceDao.updateList(cart.getCollection(), CART_FILE);
	}

	// Checks if all the quantities in the products list are all zero; sum should be zero
	@Override
	public boolean allProductsZero() {
		return (cart.getTotalQuantity() == 0);
	}

	
}
