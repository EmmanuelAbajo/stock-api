package com.solution.stockapi.service;

import java.util.List;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.entity.Stock;

public interface IStockService {
	
	/**
	 * Create and persist new stock object
	 * @param stockDto stock object creation request object. Contains name and price
	 * @return Stock stock object stored in data store
	 */
	Stock create(StockDTO stockDto);

	/**
	 * Fetch all existing stock objects
	 * @return List<StockDTO> list of stock objects
	 */
	List<StockDTO> getAll();

	/**
	 * Delete stock object from data store
	 * @param id stock object identifier
	 */
	void delete(Integer id);

	/**
	 * Fetch stock object by identifier
	 * @param id stock object identifier
	 * @return StockDTO sub stock object
	 */
	StockDTO getByID(Integer id);

	/**
	 * Update stock object name/price
	 * @param stockDto stock object update request object. Contains name and/or price
	 * @param id stock object identifier
	 * @return StockDTO sub stock object
	 */
	StockDTO update(StockDTO stockDto, Integer id);

}
