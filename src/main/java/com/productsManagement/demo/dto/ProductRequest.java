package com.productsManagement.demo.dto;

import java.time.LocalDateTime;

import com.productsManagement.demo.models.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
	
	@NotBlank(message = "name is required")
	private String name;
	
	private String description;
	
	@NotNull(message = "price is required")
	@Min(value = 0, message = "price cant to be negative")
	private double price;
	
	@Min(value = 0, message = "quantity cant to be negative")
	private int quantity;
	
	private LocalDateTime created_at;
	
	private LocalDateTime upadated_at;

	public ProductRequest(String name, String description, double price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product cast(Product product) {
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		product.setQuantity(quantity);
		
		return product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpadated_at() {
		return upadated_at;
	}

	public void setUpadated_at(LocalDateTime upadated_at) {
		this.upadated_at = upadated_at;
	}
}
