package com.iiw.supermercado.dto.product;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDTO(

    @NotBlank(message = "Nome do produto é obrigatório")
    String name,
    @NotNull(message = "Preço do produto é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço do produto deve ser maior que zero")
    BigDecimal currentPrice,

    @DecimalMin(value = "0.0", inclusive = true, message = "Preço promocional deve ser zero ou maior")
    BigDecimal promotionalPrice,

    @NotBlank(message = "tipo do produto é obrigatório")
    String type,

    @NotBlank(message = "descrição do produto é obrigatória")   
    String description,

    @ NotNull(message = "Data de validade do produto é obrigatória")
    @Future(message = "Data de validade deve ser no futuro") 
    LocalDate expirationDate
) {
}