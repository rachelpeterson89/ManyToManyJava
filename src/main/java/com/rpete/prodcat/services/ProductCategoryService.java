package com.rpete.prodcat.services;

import org.springframework.stereotype.Service;
import com.rpete.prodcat.models.ProductCategory;
import com.rpete.prodcat.repositories.ProductCategoryRepo;

@Service
public class ProductCategoryService {
	private final ProductCategoryRepo productCategoryRepo;
	
	public ProductCategoryService(ProductCategoryRepo productCategoryRepo) {
		this.productCategoryRepo = productCategoryRepo;
	}
	
	public void createProductCategory(ProductCategory productCategory) {
		productCategoryRepo.save(productCategory);
	}
}
