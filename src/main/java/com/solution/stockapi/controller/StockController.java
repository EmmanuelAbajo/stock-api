package com.solution.stockapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<StockDTO> getStock(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getByID(id));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteStock(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<StockDTO> updateStock(@PathVariable Integer id, @RequestBody StockDTO stockDto) {
		return ResponseEntity.ok(service.update(stockDto, id));
	}

}
