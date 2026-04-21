package com.iiw.supermercado.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.iiw.supermercado.dto.customer.CustomerResponseDTO;
import com.iiw.supermercado.dto.customer.CustomerCreateDTO;
import com.iiw.supermercado.dto.customer.CustomerUpdateDTO;
import com.iiw.supermercado.exception.ResourceNotFoundException;
import com.iiw.supermercado.model.Customer;
import com.iiw.supermercado.repository.CustomerRepository;
import com.iiw.supermercado.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO create(CustomerCreateDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setCpf(dto.cpf());
        customer.setAge(dto.age());

        Customer savedCustomer = customerRepository.save(customer);
        return toResponseDTO(savedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        return customerRepository
        .findAll()
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }

    @Override
    public CustomerResponseDTO findById(String id) {
        Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));

        return toResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(String id, CustomerUpdateDTO dto) {
        Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));

        customer.setName(dto.name());
        customer.setCpf(dto.cpf());
        customer.setAge(dto.age());

        Customer updatedCustomer = customerRepository.save(customer);
        return toResponseDTO(updatedCustomer);
    }

    @Override
    public void delete(String id) {
        Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));

        customerRepository.delete(customer);
    }

    private CustomerResponseDTO toResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
            customer.getId(),
            customer.getName(),
            customer.getCpf(),
            customer.getAge()
        );
    }
}