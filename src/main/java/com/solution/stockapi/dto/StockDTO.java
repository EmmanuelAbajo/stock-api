package com.solution.stockapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.solution.stockapi.entity.Stock;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockDTO {

	private Integer id;
	private String name;
	private String price;

	public StockDTO() {
		super();
	}
	
	public StockDTO(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public StockDTO(Integer id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public StockDTO(Stock stock) {
		super();
		this.id = stock.getId();
		this.name = stock.getName();
		this.price = stock.getPrice();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
