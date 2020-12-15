package com.rpete.prodcat.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.prodcat.models.ProductCategory;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Long>{
	List<ProductCategory> findAll();
}
