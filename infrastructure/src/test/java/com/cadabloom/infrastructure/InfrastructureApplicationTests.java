package com.cadabloom.infrastructure;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cadabloom.infrastructure.persistence.Product;
import com.cadabloom.infrastructure.persistence.ProductMapper;
import com.cadabloom.infrastructure.persistence.repository.ProductRepository;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestApplication.class })
class InfrastructureApplicationTests {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	@Test
	void contextLoads() {
		Product p = new Product();
		p.setName("test");
		productRepository.save(p);
		List<Product> products = productRepository.findAll();
		Assert.assertEquals(1, products.size());
	}
	
	@Test
	void mapperTest() {
		core.domain.Product productDomain = new core.domain.Product();
		productDomain.setName("test");
		
		//Product productEntity = ProductMapper.INSTANCE.productToProductEntity(p);
		Product productEntity = productMapper.productToProductEntity(productDomain);
		
		
		Assert.assertEquals(productDomain.getName(), productEntity.getName());
	}

}
