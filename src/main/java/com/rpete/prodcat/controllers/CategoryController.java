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
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("categories/new") 
	public String addCategory(@ModelAttribute("category") Category category, @ModelAttribute("product") Product product, @ModelAttribute("productCategory") ProductCategory productCategory,  Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "/categories/addCategory.jsp";
	}
	
	@PostMapping("add/categories/new")
	public String processAddCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "/categories/addCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/categories/new";
        }
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		return "/categories/showCategory.jsp";
	}
}
