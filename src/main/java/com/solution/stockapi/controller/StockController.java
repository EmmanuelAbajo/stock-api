package com.solution.stockapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.entity.Stock;
import com.solution.stockapi.service.IStockService;

@RestController
@RequestMapping(value = "/api/stocks")
public class StockController {

	private final IStockService service;

	public StockController(IStockService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(stockDto));
	}
	
	@GetMapping
	public ResponseEntity<List<StockDTO>> getStocks() {
		return ResponseEntity.ok(service.getAll());
	}

}
