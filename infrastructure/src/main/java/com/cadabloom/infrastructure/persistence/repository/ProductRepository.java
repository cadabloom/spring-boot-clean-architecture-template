package com.cadabloom.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadabloom.infrastructure.persistence.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
