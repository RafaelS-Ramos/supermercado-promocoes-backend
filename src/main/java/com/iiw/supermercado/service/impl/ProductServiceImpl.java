package com.iiw.supermercado.service.impl;

import org.springframework.stereotype.Service;
import com.iiw.supermercado.model.Product;
import com.iiw.supermercado.dto.product.ProductCreateDTO;
import com.iiw.supermercado.dto.product.ProductResponseDTO;
import com.iiw.supermercado.dto.product.ProductUpdateDTO;
import com.iiw.supermercado.repository.ProductRepository;
import com.iiw.supermercado.service.ProductService;
import com.iiw.supermercado.exception.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO create(ProductCreateDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setCurrentPrice(dto.currentPrice());
        product.setPromotionalPrice(dto.promotionalPrice());
        product.setType(dto.type());
        product.setDescription(dto.description());
        product.setExpirationDate(dto.expirationDate());

        Product savedProduct = productRepository.save(product);
        return toResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return productRepository
        .findAll()
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }

    @Override
    public ProductResponseDTO findById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado" + id));
        return toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO update(String id, ProductUpdateDTO dto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado" + id));

        product.setName(dto.name());
        product.setCurrentPrice(dto.currentPrice());
        product.setPromotionalPrice(dto.promotionalPrice());
        product.setType(dto.type());
        product.setDescription(dto.description());
        product.setExpirationDate(dto.expirationDate());

        Product updatedProduct = productRepository.save(product);
        return toResponseDTO(updatedProduct);
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        productRepository.delete(product);
    }

    @Override
    public void applyDiscountByType(String productType, BigDecimal discountPercentage) {
        List<Product> products = productRepository.findByType(productType);

        if (products.isEmpty()) {
            throw new RuntimeException("Nenhum produto encontrado para o tipo: " + productType);
        }

        for (Product product : products) {
            BigDecimal discountValue = product
            .getCurrentPrice()
            .multiply(discountPercentage)
            .divide(BigDecimal
            .valueOf(100));

            BigDecimal newPrice = product.getCurrentPrice().subtract(discountValue);

            product.setPromotionalPrice(newPrice);
        }

        productRepository.saveAll(products);
    }

    private ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getCurrentPrice(),
            product.getPromotionalPrice(),
            product.getType(),
            product.getDescription(),
            product.getExpirationDate()
        );
    }
}
