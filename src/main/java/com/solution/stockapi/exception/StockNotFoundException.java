package com.solution.stockapi.exception;

public class StockNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6071562225469243083L;
	
	public StockNotFoundException(Integer id) {
		super("Stock with ID " + id + " not found");
	}

}
