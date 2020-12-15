package com.rpete.prodcat.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.rpete.prodcat.models.Product;
import com.rpete.prodcat.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product createProduct(@Valid Product product) {
		return productRepo.save(product);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}		
	}
}
