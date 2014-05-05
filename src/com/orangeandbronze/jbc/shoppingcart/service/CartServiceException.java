package com.orangeandbronze.jbc.shoppingcart.service;

public class CartServiceException extends Exception {

	/**
	 * Throws when violations of user occur:
	 * (1) User buy products that does not exist
	 * (2) User buy more products than that being sold
	 * (3) User buy products with negative quantity
	 * (4) User buy products with zero quantity
	 * 
	 * Messages are shown to user using the String parameter of this exception.
	 */
	private static final long serialVersionUID = -7304820250257761005L;

	public CartServiceException() {
	}

	public CartServiceException(String arg0) {
		super(arg0);
	}

	public CartServiceException(Throwable arg0) {
		super(arg0);
	}

	public CartServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CartServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
