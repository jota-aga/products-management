package com.productsManagement.demo.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super("product not found");
		// TODO Auto-generated constructor stub
	}

}
