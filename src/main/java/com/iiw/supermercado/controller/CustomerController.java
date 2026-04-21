package com.iiw.supermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iiw.supermercado.dto.customer.CustomerCreateDTO;
import com.iiw.supermercado.dto.customer.CustomerResponseDTO;
import com.iiw.supermercado.dto.customer.CustomerUpdateDTO;
import com.iiw.supermercado.service.CustomerService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO create(@RequestBody @Valid CustomerCreateDTO dto) {
        return customerService.create(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> findAll(){
        return customerService.findAll();
    }
    
    @GetMapping("/{id}")
    public CustomerResponseDTO findById(@PathVariable String id) {
        return customerService.findById(id);
    }
    
    @PutMapping("/{id}")
    public CustomerResponseDTO update(@PathVariable String id, @RequestBody @Valid CustomerUpdateDTO dto) {
        return customerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }
}