package com.orangeandbronze.jbc.shoppingcart.consoleui;

import com.orangeandbronze.jbc.shoppingcart.dao.CartServiceDaoException;
import com.orangeandbronze.jbc.shoppingcart.service.CartService;
import com.orangeandbronze.jbc.shoppingcart.service.CartServiceException;
import com.orangeandbronze.jbc.shoppingcart.service.CartServiceImpl;

public class Runner {
	/*
	 * Presentation layer.
	 * Command-line arguments:
	 * 
	 * list-products	lists products being sold.
	 * show-cart		lists products currently inside the shopping cart.
	 * buy pn qn		buy product specified by pn with quantity specified by qn
	 */
	
	public static void main(String[] args){
		CartService service;
		try {
			service = new CartServiceImpl();
			final int COMMAND = 0;
			String regex = "[0-9]+";
			
			if(args.length == 1 && args[COMMAND].equals("list-products")){
				System.out.println("Product List");
				System.out.println("------------------------------------");
				System.out.println("No.\tName\tPrice\tQty");
				System.out.println("------------------------------------");
				String list = service.showList("products");
				if(list.equals("") || service.allProductsZero()){
					System.out.println("No products to be sold.");
				} else {
					System.out.print(list);
				}
			}
			else if(args.length == 1 && args[COMMAND].equals("show-cart")){
				System.out.println("Shopping Cart");
				System.out.println("------------------------------------");
				System.out.println("No.\tName\tPrice\tQty");
				System.out.println("------------------------------------");
				String list = service.showList("shopping");
				if (list.equals("")){
					System.out.println("Shopping cart empty.");
				} else {
					System.out.print(list);
					System.out.println("Total: " + service.getGrandTotal().toPlainString());
				}
			}
			else if(args.length == 3 && args[COMMAND].equals("buy") && args[1].matches(regex) && args[2].matches(regex)){
				System.out.println(service.buy(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			}
			else {
				System.out.println("Invalid input! Try again.");
			}
			
		} catch (CartServiceDaoException e) {
			System.out.println(e.getMessage());
		} catch (CartServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}
