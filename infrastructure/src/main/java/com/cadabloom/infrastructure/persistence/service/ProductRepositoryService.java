package com.cadabloom.infrastructure.persistence.service;

import com.cadabloom.infrastructure.persistence.mapper.ProductMapper;
import com.cadabloom.infrastructure.persistence.repository.ProductRepository;

import core.contracts.persistence.GenericRepository;
import core.domain.Product;

public class ProductRepositoryService implements GenericRepository<Product> {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	public ProductRepositoryService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public Product save(Product product) {
		com.cadabloom.infrastructure.persistence.entities.Product entity = productMapper.productToProductEntity(product);
		productRepository.save(entity);
		return productMapper.productEntityToProduct(entity);
	}

	@Override
	public Boolean deleteAll() {
		productRepository.deleteAll();
		return true;
	}

	@Override
	public Product findById(int id) {
		com.cadabloom.infrastructure.persistence.entities.Product entity = productRepository.findById(id).orElse(null);
		return productMapper.productEntityToProduct(entity);
	}
}
