package com.lumorix.hatcomm.product.mapper;

import com.lumorix.hatcomm.product.dto.CreateProductRequest;
import com.lumorix.hatcomm.product.entity.ProductEntity;
import com.lumorix.hatcomm.product.enumeration.ProductStatus;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductEntity toResponse(CreateProductRequest productRequest){
        ProductEntity product = new ProductEntity();
        product.setDescription(productRequest.description());
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        return product;
    }
}
