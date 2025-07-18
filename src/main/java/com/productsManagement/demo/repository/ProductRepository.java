package com.productsManagement.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsManagement.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByNameIgnoreCase(String name);
}
