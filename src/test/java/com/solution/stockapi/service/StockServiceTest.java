package com.solution.stockapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.entity.Stock;
import com.solution.stockapi.exception.StockNotFoundException;
import com.solution.stockapi.repository.StockRepository;
import com.solution.stockapi.service.impl.StockService;

public class StockServiceTest {
	
	private IStockService service;
	private StockRepository mockRepo;
	
	@BeforeEach
	void setUp() {
		this.mockRepo = Mockito.mock(StockRepository.class);
		this.service = new StockService(mockRepo);
		
		Mockito.when(this.mockRepo.save(Mockito.any(Stock.class))).thenReturn(new Stock("test stock", "2000"));
	}
	
	@Test
	@DisplayName("Stock object creation returns null Test")
	void test_stock_creation_returns_not_null() {
		Assertions.assertNotNull(service.create(new StockDTO()));
	}
	
	@Test
	@DisplayName("Stock object creation Test")
	void test_stock_creation() {
		Assertions.assertEquals("2000", service.create(new StockDTO()).getPrice(), "Stock price should be 2000");
	}
	
	@Test
	@DisplayName("Stock object deletion Test")
	void test_stock_deletion_throws_stock_not_found_exception() {
		Assertions.assertThrows(StockNotFoundException.class, () -> service.delete(1));
	}
	
	@Test
	@DisplayName("Stock object update Test throws exception Test")
	void test_stock_update_throws_stock_not_found_exception() {
		Assertions.assertThrows(StockNotFoundException.class, () -> service.update(new StockDTO(), 1));
	}


}
