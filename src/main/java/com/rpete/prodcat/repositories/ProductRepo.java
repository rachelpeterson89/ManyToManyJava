package com.rpete.prodcat.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.prodcat.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
}
