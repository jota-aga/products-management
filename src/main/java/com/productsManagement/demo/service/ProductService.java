package com.productsManagement.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsManagement.demo.exception.NameAlreadyRegisteredException;
import com.productsManagement.demo.exception.ProductNotFoundException;
import com.productsManagement.demo.models.Product;
import com.productsManagement.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	public void saveProduct(Product product) {
		Optional<Product> productRepeat = repo.findByNameIgnoreCase(product.getName());
		
		if(productRepeat.isPresent()) {
			throw new NameAlreadyRegisteredException();
		}
		
		product.setCreated_at(LocalDateTime.now());
		product.setUpdated_at(LocalDateTime.now());
	
		repo.save(product);
	}
	
	public void saveEditedProduct(Product product) {
		Optional<Product> productRepeat = repo.findByNameIgnoreCase(product.getName());
		
		if(productRepeat.isPresent() && productRepeat.get().getId() != product.getId()) {
			throw new NameAlreadyRegisteredException();
		}
		
		product.setUpdated_at(LocalDateTime.now());
		
		repo.save(product);
	}
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public Product findById(long id) {
		Optional<Product> product = repo.findById(id);
		
		if(product.isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		return product.get();
	}
	
	public void deleteProduct(long id) {
		Optional<Product> product = repo.findById(id);
		
		if(product.isEmpty()) {
			throw new ProductNotFoundException();
		}
		
		repo.delete(product.get());
	}
}
