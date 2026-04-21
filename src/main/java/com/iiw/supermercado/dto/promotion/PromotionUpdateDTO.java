package com.iiw.supermercado.dto.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PromotionUpdateDTO(
    @NotBlank(message = "Titulo da promoção é obrigatório")
    String title,

    @NotBlank(message = "Descrição do produto é obrigatório")
    String description,

    @NotNull(message = "Porcentagem do desconto é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Porcentagem do desconto tem que ser maior que zero")
    BigDecimal discountPercentage,

    String productType,

    String productId,

    String customerId,

    @NotNull(message = "Data de inicio é obrigatório")
    LocalDateTime startDate,

    @NotNull(message = "Data do fim é obrigatório")
    LocalDateTime endDate,

    @NotNull(message = "Active flag is required")
    Boolean active
) {
}
