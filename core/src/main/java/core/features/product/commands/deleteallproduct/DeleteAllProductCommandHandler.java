package core.features.product.commands.deleteallproduct;

import core.contracts.persistence.GenericRepository;
import core.domain.Product;
import core.mediatior.RequestHandler;

public class DeleteAllProductCommandHandler implements RequestHandler<DeleteAllProductCommand, DeleteAllProductCommandDto> {

	private final GenericRepository<Product> productRepository;
	public DeleteAllProductCommandHandler(GenericRepository<Product> repo) {
		this.productRepository = repo;
	}
	
	@Override
	public DeleteAllProductCommandDto handle(DeleteAllProductCommand request) {
		this.productRepository.deleteAll();
		DeleteAllProductCommandDto dto = new DeleteAllProductCommandDto();
		dto.setSuccess(true);
		return dto;
	}

}
