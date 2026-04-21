package com.iiw.supermercado.service;

import java.math.BigDecimal;
import java.util.List;
import com.iiw.supermercado.dto.product.ProductCreateDTO;
import com.iiw.supermercado.dto.product.ProductResponseDTO;
import com.iiw.supermercado.dto.product.ProductUpdateDTO;

public interface ProductService {
    ProductResponseDTO create(ProductCreateDTO dto);

    List<ProductResponseDTO> findAll();

    ProductResponseDTO findById(String id);

    ProductResponseDTO update(String id, ProductUpdateDTO dto);

    void delete(String id);

    void applyDiscountByType(String productType, BigDecimal discountPercentage);
}
