package com.example.Spring.thymeleafdemo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.Spring.thymeleafdemo.model.Product;



public interface ProductService {
	
	public List<Product> findAll();

	public void save(Product theEmployee);
	
	public Product findById(int theId);
	
	public void deleteById(int theId);
	
	Page<Product>  findPiginatedData(int pageNo, int pageSize);
	


}
