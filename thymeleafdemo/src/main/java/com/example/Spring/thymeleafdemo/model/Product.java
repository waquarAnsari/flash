package com.example.Spring.thymeleafdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int ProductId;
	
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="product_Category")
	private String productCategory;

	

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {
		
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String productName, double price, String productCategory) {
		super();
		this.ProductId = id;
		this.productName = productName;
		this.price = price;
		this.productCategory = productCategory;
	}
	
	
}
