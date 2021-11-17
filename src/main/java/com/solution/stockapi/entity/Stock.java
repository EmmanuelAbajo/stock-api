package com.solution.stockapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Stock {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "current_price")
	private String price;

	private Date create_date;
	private Date last_update;

	@PrePersist
	protected void onCreate() {
		this.create_date = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.last_update = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

}
