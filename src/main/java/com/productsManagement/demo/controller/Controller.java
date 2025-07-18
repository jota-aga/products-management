		package com.productsManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.productsManagement.demo.dto.ProductRequest;
import com.productsManagement.demo.models.Product;
import com.productsManagement.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class Controller {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/products/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductRequest productDto){
		Product product = new Product();
		product = productDto.cast(product);
		service.saveProduct(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping("/products")
	public List<Product> allProducts(){
		return service.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable long id){
		Product product = service.findById(id);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(product);
	}
	
	@PutMapping("/products/edit/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable long id, @Valid @RequestBody ProductRequest productDto){
		Product product = service.findById(id);
		product = productDto.cast(product);
		
		service.saveEditedProduct(product);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
		
	}
	
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		service.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
}
