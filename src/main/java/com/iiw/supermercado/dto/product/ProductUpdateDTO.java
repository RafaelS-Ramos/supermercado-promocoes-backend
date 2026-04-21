package com.iiw.supermercado.dto.product;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDTO(
    @NotBlank(message = "O nome do produto é obrigatório")
    String name,

    @NotNull(message = "O preço do produto é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço do produto deve ser maior que zero")
    BigDecimal currentPrice,

    @DecimalMin(value = "0.0", inclusive = false, message = "O preço promocional do produto deve ser zero ou maior")
    BigDecimal promotionalPrice,

    @NotBlank(message = "O tipo do produto é obrigatório")
    String type,

    @NotBlank(message = "A descrição do produto é obrigatória")
    String description,

    @NotNull(message = "A data de validade do produto é obrigatória")
    @Future(message = "A data de validade do produto deve ser no futuro")
    LocalDate expirationDate
) {
}
