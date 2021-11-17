package com.solution.stockapi.service;

import java.util.List;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.entity.Stock;

public interface IStockService {
	
	Stock create(StockDTO stockDto);
	List<StockDTO> getAll();

}
