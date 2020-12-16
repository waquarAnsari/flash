package com.example.Spring.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring.thymeleafdemo.model.Product;
import com.example.Spring.thymeleafdemo.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		return viewPage(1, theModel);
		
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "Product/Product-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("product") Product theProduct) {
		
		// save the employee
		productService.save(theProduct);
		
		
		return "redirect:/products/list";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Product theEmployee = productService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("product", theEmployee);
		
		// send over to our form
		return "Product/Product-form";			
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
		
		// delete the employee
		productService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/products/list";
		
	}
	
	@GetMapping("/page/{pageNo}")
	public String viewPage(@PathVariable (value = "pageNo") int pageNo,Model model) {
		int pageSize = 5;
		Page<Product> page = productService.findPiginatedData(pageNo, pageSize);
		List<Product> listProduct = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listProduct", listProduct);
		return "product/list-products";
	}

}
