package com.solution.stockapi.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.service.IStockService;

@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStockService service;

	@Override
	public void run(String... args) throws Exception {
		StockDTO stock1 = new StockDTO("Stock1", "2000");
		StockDTO stock2 = new StockDTO("Stock2", "3000");

		service.create(stock1);
		service.create(stock2);

		logger.info("Data loaded successfully");

	}

}
