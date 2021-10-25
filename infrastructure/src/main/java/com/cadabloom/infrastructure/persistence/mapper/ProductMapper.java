package com.cadabloom.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cadabloom.infrastructure.persistence.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	 
    Product productToProductEntity(core.domain.Product product);
    
    core.domain.Product productEntityToProduct(Product entity);
}
