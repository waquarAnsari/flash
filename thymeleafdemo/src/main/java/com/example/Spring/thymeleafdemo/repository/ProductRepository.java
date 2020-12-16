package com.example.Spring.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Spring.thymeleafdemo.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	


}
