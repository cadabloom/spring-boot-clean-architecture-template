package core.features.product.commands.createproduct;

import core.contracts.persistence.GenericRepository;
import core.domain.Product;

public class CreateProductCommandHandler implements CreateProductCommand {

	private final GenericRepository<Product> productRepository;
	public CreateProductCommandHandler(GenericRepository<Product> repo) {
		this.productRepository = repo;
	}
	
	public CreateProductDto create(String name) {
		Product product = new Product(name); 
		product = productRepository.save(product);
		return CreateProductMapper.INSTANCE.productToCreateProductDto(product);
	}

}
