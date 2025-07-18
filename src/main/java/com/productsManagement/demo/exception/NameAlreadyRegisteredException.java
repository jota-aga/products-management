package com.productsManagement.demo.exception;

public class NameAlreadyRegisteredException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameAlreadyRegisteredException() {
		super("name already registered");
	}
}
