package com.lumorix.hatcomm.product.dto;

import java.math.BigDecimal;

public record CreateProductRequest(String name,
                                   String description,
                                   BigDecimal price) {
}
