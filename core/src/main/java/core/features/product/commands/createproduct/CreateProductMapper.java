package core.features.product.commands.createproduct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import core.domain.Product;

@Mapper
public interface CreateProductMapper {
	CreateProductMapper INSTANCE = Mappers.getMapper(CreateProductMapper.class);
	 
    CreateProductDto productToCreateProductDto(Product product);
    
}
