package org.gdm.store.GoldenDomeMarket.service.impl;

import java.util.List;

import org.gdm.store.GoldenDomeMarket.model.Product;
import org.gdm.store.GoldenDomeMarket.repository.ProductRepository;
import org.gdm.store.GoldenDomeMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
		
	
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Page<Product> getAllProducts(int pageNo) {
		
		return productRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("productNumber")));
	}
	
	@Override
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}

}
