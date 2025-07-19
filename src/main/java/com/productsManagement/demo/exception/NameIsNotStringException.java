package com.productsManagement.demo.exception;


public class NameIsNotStringException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameIsNotStringException() {
		super("Name is not String");
	}
}
