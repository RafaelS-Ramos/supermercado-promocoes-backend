package com.iiw.supermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iiw.supermercado.dto.product.ProductBulkDiscountDTO;
import com.iiw.supermercado.dto.product.ProductCreateDTO;
import com.iiw.supermercado.dto.product.ProductResponseDTO;
import com.iiw.supermercado.dto.product.ProductUpdateDTO;
import com.iiw.supermercado.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO create(@RequestBody @Valid ProductCreateDTO dto) {
        return productService.create(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> findAll() {
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public ProductResponseDTO findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(@PathVariable String id, @RequestBody @Valid ProductUpdateDTO dto) {
        return productService.update(id, dto);       
    }

    @PatchMapping("/bulk-discount")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void applyDiscount(@RequestBody @Valid ProductBulkDiscountDTO dto) {
        productService.applyDiscountByType(dto.productType(), dto.discountPercentage());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
