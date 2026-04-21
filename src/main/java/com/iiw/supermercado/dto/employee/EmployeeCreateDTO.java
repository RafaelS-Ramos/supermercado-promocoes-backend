package com.iiw.supermercado.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeCreateDTO(
    @NotBlank(message = "Nome do empregado é obrigatório")
    String name,

    @NotBlank(message = "CPF do empregado é obrigatório")
    String cpf,

    @NotBlank(message = "Email do empregado é obrigatório")
    @Email(message = "formato do email inválido")
    String email,

    @NotBlank(message = "Senha do empregado é obrigatório")
    String password,

    @NotBlank(message = "função do empregado é obrigatório")
    String role
){
}
