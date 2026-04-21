package com.iiw.supermercado.dto.purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseResponseDTO(
    String id,
    String customerId,
    String productId,
    String productName,
    String productType,
    BigDecimal price,
    LocalDateTime purchaseDate
) {
}