package org.gdm.store.GoldenDomeMarket.service;

import java.util.List;

import org.gdm.store.GoldenDomeMarket.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
	
	List<Product> getAllProducts();
	Page<Product> getAllProducts(int pageNo);
	Product addNewProduct(Product product);

}
