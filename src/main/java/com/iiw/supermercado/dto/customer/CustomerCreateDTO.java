package com.iiw.supermercado.dto.customer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerCreateDTO(
    @NotBlank(message = "Nome do cliente é obrigatório")
    String name,

    @NotBlank(message = "CPF do cliente é obrigatório")
    String cpf,

    @NotNull(message = "Idade do cliente é obrigatória")
    @Min(value = 0, message = "Idade do cliente deve ser maior ou igual a 0")
    Integer age
) {
}
