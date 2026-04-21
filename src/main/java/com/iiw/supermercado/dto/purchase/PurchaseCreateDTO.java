package com.iiw.supermercado.dto.purchase;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PurchaseCreateDTO(
    @NotBlank(message = "id do cliente é obrigatório")
    String customerId,

    @NotBlank(message = "id do produto é obrigatório")
    String productId,

    @NotBlank(message = "nome do produto é obrigatório")
    String productName,

    @NotBlank(message = "tipo do produto é obrigatório")
    String productType,

    @NotNull(message = "Preço do produto é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço do produto não pode ser igual ou menor que zero")
    BigDecimal price
){
}
