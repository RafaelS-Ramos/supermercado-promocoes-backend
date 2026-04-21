package com.iiw.supermercado.dto.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PromotionResponseDTO(
    String id,
    String title,
    String description,
    BigDecimal discountPercentage,
    String productType,
    String productId,
    String customer,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Boolean active
) {
}
