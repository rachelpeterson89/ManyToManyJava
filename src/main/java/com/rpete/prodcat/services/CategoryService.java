package com.rpete.prodcat.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.rpete.prodcat.models.Category;
import com.rpete.prodcat.repositories.CategoryRepo;

@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;
	
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
	public Category createCategory(@Valid Category category) {
		return categoryRepo.save(category);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}		
	}

}
