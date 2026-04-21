package com.iiw.supermercado.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.iiw.supermercado.model.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
    List<Purchase> findByCustomerId(String customerId);
}
