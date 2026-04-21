package com.iiw.supermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iiw.supermercado.dto.purchase.PurchaseCreateDTO;
import com.iiw.supermercado.dto.purchase.PurchaseResponseDTO;
import com.iiw.supermercado.service.PurchaseService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseResponseDTO create(@RequestBody @Valid PurchaseCreateDTO dto) {
        return purchaseService.create(dto);
    }
    
    @GetMapping
    public List<PurchaseResponseDTO> findAll() {
        return purchaseService.findAll();
    }
    
    @GetMapping("/{id}")
    public PurchaseResponseDTO findById(@PathVariable String id) {
        return purchaseService.findById(id);
    }
    
    @GetMapping("/customer/{customerId}")
    public List<PurchaseResponseDTO> findByCustomerId(@PathVariable String customerId) {
        return purchaseService.findByCustomerId(customerId);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        purchaseService.delete(id);
    }
}
