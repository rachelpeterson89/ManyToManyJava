package com.rpete.prodcat.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rpete.prodcat.models.Category;
import com.rpete.prodcat.models.Product;
import com.rpete.prodcat.models.ProductCategory;
import com.rpete.prodcat.services.CategoryService;
import com.rpete.prodcat.services.ProductService;


@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category, @ModelAttribute("productCategory") ProductCategory productCategory,  Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "/products/addProduct.jsp";
	}
	
	@PostMapping("/add/products/new")
	public String processAddProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "/products/addProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/products/new";
        }
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return "/products/showProduct.jsp";
	}
}
