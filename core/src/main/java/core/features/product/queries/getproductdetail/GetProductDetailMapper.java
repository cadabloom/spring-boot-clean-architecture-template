package core.features.product.queries.getproductdetail;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import core.domain.Product;

@Mapper
public interface GetProductDetailMapper {
	GetProductDetailMapper INSTANCE = Mappers.getMapper(GetProductDetailMapper.class);
	
	@Mapping(source = "name", target = "productName")
	ProductDetailDto productToProductDetailDto(Product product);
}
