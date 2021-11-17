package com.solution.stockapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.solution.stockapi.repository.StockRepository;

@Service
public class StockService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final StockRepository repo;

	public StockService(StockRepository repo) {
		super();
		this.repo = repo;
	}

}
