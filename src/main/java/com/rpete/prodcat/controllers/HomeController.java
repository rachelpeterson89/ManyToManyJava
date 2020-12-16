package com.rpete.prodcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpete.prodcat.models.Category;
import com.rpete.prodcat.models.Product;
import com.rpete.prodcat.services.HomeService;

@Controller
public class HomeController {
	
	private static HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	
	// show jsp template with form to add new product
	@RequestMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category, Model model) {
		model.addAttribute("products", homeService.getProducts());
		model.addAttribute("categories", homeService.getCategories());
		return "/products/addProduct.jsp";
	}
	
	
	// submit new product form
	@PostMapping("/add/products/new")
	public String processAddProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "/products/addProduct.jsp";
        } else {
            homeService.create(product);
            return "redirect:/products/new";
        }
	}
	
	
	// show product jsp file based on id
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product currentProduct = homeService.getProduct(id);
		model.addAttribute("allCategories", homeService.getCategories());
		model.addAttribute("currentProduct", currentProduct);
		return "/products/showProduct.jsp";
	}
	
	
	// submit add product to category form
	@PostMapping("/products/{id}")
	public String addCatToProd(@PathVariable("id") Long id, Model model, @RequestParam("category_id") Long categoryId) {
		Product currentProduct = homeService.getProduct(id);
		Category addedCategory = homeService.getCategory(categoryId);
		List<Category> catProd = currentProduct.getCategories();
		catProd.add(addedCategory);
		homeService.saveProduct(currentProduct);
		return "redirect:/products/" + id;
	}
	
	
	// show jsp template with form to add new category
	@RequestMapping("categories/new") 
	public String addCategory(@ModelAttribute("category") Category category, @ModelAttribute("product") Product product,  Model model) {
		model.addAttribute("products", homeService.getProducts());
		model.addAttribute("categories", homeService.getCategories());
		return "/categories/addCategory.jsp";
	}
	
	
	// submit new category form
	@PostMapping("add/categories/new")
	public String processAddCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "/categories/addCategory.jsp";
        } else {
            homeService.create(category);
            return "redirect:/categories/new";
        }
	}
	
	
	// show category jsp file based on id
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category currentCategory = homeService.getCategory(id);
		model.addAttribute("allProducts", homeService.getProducts());
		model.addAttribute("currentCategory", currentCategory);
		return "/categories/showCategory.jsp";
	}
	
	// submit add product to category form
	@PostMapping("/categories/{id}")
	public String addProdToCat(@PathVariable("id") Long id, Model model, @RequestParam("product_id") Long productId) {
		Category currentCategory = homeService.getCategory(id);
		Product addedProduct = homeService.getProduct(productId);
		List<Product> prodCat = currentCategory.getProducts();
		prodCat.add(addedProduct);
		homeService.saveCategory(currentCategory);
		return "redirect:/categories/" + id;
	}
	
	
}
