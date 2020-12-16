package com.rpete.prodcat.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.rpete.prodcat.models.Category;
import com.rpete.prodcat.models.Product;
import com.rpete.prodcat.repositories.CategoryRepo;
import com.rpete.prodcat.repositories.ProductRepo;


@Service
public class HomeService {
	
	private static ProductRepo productRepo;
	private static CategoryRepo categoryRepo;
	
	public HomeService(ProductRepo productRepo, CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	public Product create(Product newProduct) {
		return productRepo.save(newProduct);
	}
	
	public Category create(Category newCategory) {
		return categoryRepo.save(newCategory);
	}
	
	public List<Product> getProducts() {
		return (List<Product>) productRepo.findAll();
	}
	
	public List<Category> getCategories() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Product getProduct(Long id) {
		Optional<Product> product = productRepo.findById(id);
		return product.isPresent() ? product.get() : null;
	}
	
	public Category getCategory(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		return category.isPresent() ? category.get() : null;
	}
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
}
