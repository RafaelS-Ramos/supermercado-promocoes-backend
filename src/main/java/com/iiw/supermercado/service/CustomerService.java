package com.iiw.supermercado.service;

import java.util.List;
import com.iiw.supermercado.dto.customer.CustomerCreateDTO;
import com.iiw.supermercado.dto.customer.CustomerResponseDTO;
import com.iiw.supermercado.dto.customer.CustomerUpdateDTO;

public interface CustomerService {
    CustomerResponseDTO create(CustomerCreateDTO dto);
    
    List<CustomerResponseDTO> findAll();

    CustomerResponseDTO findById(String id);

    CustomerResponseDTO update(String id, CustomerUpdateDTO dto);

    void delete(String id);
}
