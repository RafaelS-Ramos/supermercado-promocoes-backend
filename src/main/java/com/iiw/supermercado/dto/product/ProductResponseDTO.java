package com.iiw.supermercado.dto.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductResponseDTO(
    String id,
    String name,
    BigDecimal currentPrice,
    BigDecimal promotionalPrice,
    String type,
    String description,
    LocalDate expirationDate
) {
}