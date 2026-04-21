package com.iiw.supermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iiw.supermercado.dto.promotion.PromotionCreateDTO;
import com.iiw.supermercado.dto.promotion.PromotionResponseDTO;
import com.iiw.supermercado.dto.promotion.PromotionUpdateDTO;
import com.iiw.supermercado.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromotionResponseDTO create(@RequestBody @Valid PromotionCreateDTO dto) {        
        return promotionService.create(dto);
    }
    
    @GetMapping
    public List<PromotionResponseDTO> findAll() {
        return promotionService.findAll();
    }

    @GetMapping("/{id}")
    public PromotionResponseDTO findById(@PathVariable String id) {
        return promotionService.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<PromotionResponseDTO> findPromotionsForCustomer(@PathVariable String customerId) {
        return promotionService.findPromotionsForCustomer(customerId);
    }
    
    @PutMapping("/{id}")
    public PromotionResponseDTO update(@PathVariable String id, @RequestBody @Valid PromotionUpdateDTO dto) {        
        return promotionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        promotionService.delete(id);
    }
}
