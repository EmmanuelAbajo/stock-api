package com.solution.stockapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.stockapi.service.IStockService;

@RestController
@RequestMapping(value="/api/stocks")
public class StockController {
	
	private final IStockService service;

	public StockController(IStockService service) {
		super();
		this.service = service;
	}
	
	

}
