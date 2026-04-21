package com.iiw.supermercado.dto.customer;

public record CustomerResponseDTO(
    String id, 
    String name, 
    String cpf, 
    Integer age
) {
}
