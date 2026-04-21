package com.iiw.supermercado.dto.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductBulkDiscountDTO(
    @NotBlank(message = "Tipo do produto é obrigatório")
    String productType,

    @NotNull(message = "Desconto é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    BigDecimal discountPercentage
) {
    
}