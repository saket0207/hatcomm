package com.lumorix.hatcomm.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long productId,
        String name,
        String description,
        String status,
        BigDecimal price
) {
}
