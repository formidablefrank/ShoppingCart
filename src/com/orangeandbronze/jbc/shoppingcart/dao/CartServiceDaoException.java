package com.orangeandbronze.jbc.shoppingcart.dao;

public class CartServiceDaoException extends Exception {

	/**
	 * Thrown if there is an error accessing the products and cart files.
	 * Wraps IOException.
	 */
	private static final long serialVersionUID = 387409939144259519L;

	public CartServiceDaoException() {
	}

	public CartServiceDaoException(String arg0) {
		super(arg0);
	}

	public CartServiceDaoException(Throwable arg0) {
		super(arg0);
	}

	public CartServiceDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CartServiceDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
