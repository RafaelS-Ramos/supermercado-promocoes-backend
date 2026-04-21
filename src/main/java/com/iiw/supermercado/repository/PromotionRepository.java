package com.iiw.supermercado.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.iiw.supermercado.model.Promotion;

public interface PromotionRepository extends MongoRepository<Promotion, String> {
    List<Promotion> findByCustomerIdAndActiveTrue(String customerId, boolean active);
    List<Promotion> findByProductTypeAndActiveTrue(String productType);
    List<Promotion> findByActiveTrue(boolean active);

    List<Promotion> findByCustomerIdIsNullAndProductTypeIsNullAndActiveTrue();
}
