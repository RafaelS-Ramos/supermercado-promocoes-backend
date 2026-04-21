package com.iiw.supermercado.dto.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PromotionCreateDTO(
    @NotBlank(message = "Título da promoção é obrigatória")
    String title,
    
    @NotBlank(message = "Descrição da promoção é obrigatória")
    String description,

    @NotNull(message = "Porcentagem dedesconto é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "A porcentagem do desconto tem que ser maior que zero")
    BigDecimal discountPercentage,

    String productType,

    String productId,

    String customerId,

    @NotNull(message = "Data do início é obrigatório")
    LocalDateTime startDate,

    @NotNull(message = "Data do fim é obrigatório")
    LocalDateTime endDate,

    @NotNull(message = "Active flag is required")
    boolean active
) {
}