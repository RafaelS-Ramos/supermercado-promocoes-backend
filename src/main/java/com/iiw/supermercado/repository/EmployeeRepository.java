package com.iiw.supermercado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.iiw.supermercado.model.Employee;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByCpf(String cpf);
}
