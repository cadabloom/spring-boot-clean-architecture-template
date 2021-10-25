package com.cadabloom.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadabloom.infrastructure.persistence.Product;
import com.cadabloom.infrastructure.persistence.ProductMapper;
import com.cadabloom.infrastructure.persistence.repository.ProductRepository;

import core.features.product.commands.createproduct.CreateProductCommand;
import core.features.product.commands.createproduct.CreateProductDto;
import core.features.product.commands.deleteallproduct.DeleteAllProductCommand;
import core.features.product.commands.deleteallproduct.DeleteAllProductCommandDto;
import core.mediatior.RequestMediator;
import core.mediatior.RequestHandler;
import core.mediatior.TestHandler;
import core.mediatior.TestRequest;

@RestController
public class TestController {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CreateProductCommand createProductCommand;
	
	@Autowired
	RequestMediator mediator;

	@GetMapping("/products")  
	private List<Product> getAll()   
	{  
		CreateProductDto dto = createProductCommand.create("test");
		return productRepository.findAll();  
		
	}  
	
	@GetMapping("/product")  
	private core.domain.Product get()   
	{  
		core.domain.Product product = mediator.send(new TestRequest());
		return product;
		
	}  
	
	@GetMapping("/delete")  
	private DeleteAllProductCommandDto getDelete()   
	{  
		DeleteAllProductCommandDto dto = mediator.send(new DeleteAllProductCommand());
		return dto;
		
	}  
}
