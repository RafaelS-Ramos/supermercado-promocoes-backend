package com.iiw.supermercado.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.iiw.supermercado.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    Optional<Customer> findByCpf(String cpf);
}