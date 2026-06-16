package com.lumorix.hatcomm.product.mapper;

import com.lumorix.hatcomm.product.dto.ProductResponse;
import com.lumorix.hatcomm.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toResponse(ProductEntity productEntity){
        return new ProductResponse(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getStatus().name(),
                productEntity.getPrice()
        );
    }
}
