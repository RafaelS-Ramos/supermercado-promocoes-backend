package com.iiw.supermercado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.iiw.supermercado.model.Product;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByType(String type);
}
