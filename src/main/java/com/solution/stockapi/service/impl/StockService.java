package com.solution.stockapi.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.solution.stockapi.dto.StockDTO;
import com.solution.stockapi.entity.Stock;
import com.solution.stockapi.exception.StockNotFoundException;
import com.solution.stockapi.repository.StockRepository;
import com.solution.stockapi.service.IStockService;

@Service
public class StockService implements IStockService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final StockRepository repo;

	public StockService(StockRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Stock create(StockDTO stockDto) {
		logger.info("Creating new Stock: {}", stockDto);
		return repo.save(new Stock(stockDto.getName(), stockDto.getPrice()));
	}

	@Override
	public List<StockDTO> getAll() {
		List<StockDTO> stocks = new ArrayList<>();
		try {
			logger.info("Getting all stocks");
			Iterator<Stock> result = repo.findAll().iterator();
			while (result.hasNext()) {
				Stock stock = result.next();
				stocks.add(new StockDTO(stock));
			}
		} catch (Exception ex) {
			logger.error("Error in fetching all stocks: {}", ex.getMessage());

		}

		return stocks;
	}

	@Override
	public void delete(Integer id) {
		logger.info("Deleting stock with id: {}", id.toString());
		repo.findById(id).orElseThrow(() -> new StockNotFoundException(id));
		repo.deleteById(id);
	}

	@Override
	public StockDTO getByID(Integer id) {
		logger.info("Finding stock with id: {}", id.toString());
		return repo.findById(id).map(StockDTO::new).orElseThrow(() -> new StockNotFoundException(id));
	}

	@Override
	public StockDTO update(StockDTO stockDto, Integer id) {
		logger.info("Updating stock id {} details with {}", id.toString(), stockDto);
		return repo.findById(id).map(stock -> {
			if (!Objects.isNull(stockDto.getName())) {
				stock.setName(stockDto.getName());
			}

			if (!Objects.isNull(stockDto.getPrice())) {
				stock.setName(stockDto.getPrice());
			}

			return repo.save(stock);
		}).map(StockDTO::new).orElseThrow(() -> new StockNotFoundException(id));

	}
}
