package com.iiw.supermercado.dto.employee;

public record EmployeeResponseDTO(
    String id,
    String name,
    String cpf,
    String email,
    String role
) {
}
