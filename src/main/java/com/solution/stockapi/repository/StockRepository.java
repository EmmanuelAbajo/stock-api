package com.solution.stockapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.solution.stockapi.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
