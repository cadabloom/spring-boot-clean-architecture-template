package com.cadabloom.infrastructure.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	 
    Product productToProductEntity(core.domain.Product product);
    
    core.domain.Product productEntityToProduct(Product entity);
}
