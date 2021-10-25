package core.features.product.queries.getproductdetail;

import core.contracts.persistence.GenericRepository;
import core.domain.Product;
import core.mediatior.RequestHandler;

public class GetProductDetailQueryHandler implements RequestHandler<GetProductDetailQuery, ProductDetailDto> {

	private final GenericRepository<Product> productRepository;
	
	public GetProductDetailQueryHandler(GenericRepository<Product> repo) {
		this.productRepository = repo;
	}
	
	@Override
	public ProductDetailDto handle(GetProductDetailQuery request) {
		Product product = productRepository.findById(request.getId());
		return GetProductDetailMapper.INSTANCE.productToProductDetailDto(product);
	}
	
}
