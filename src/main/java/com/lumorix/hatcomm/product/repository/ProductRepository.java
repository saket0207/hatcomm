package com.lumorix.hatcomm.product.repository;

import com.lumorix.hatcomm.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
