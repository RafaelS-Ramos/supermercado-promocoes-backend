package com.iiw.supermercado.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iiw.supermercado.dto.purchase.PurchaseCreateDTO;
import com.iiw.supermercado.dto.purchase.PurchaseResponseDTO;
import com.iiw.supermercado.exception.ResourceNotFoundException;
import com.iiw.supermercado.model.Purchase;
import com.iiw.supermercado.repository.PurchaseRepository;
import com.iiw.supermercado.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseResponseDTO create(PurchaseCreateDTO dto) {
        Purchase purchase = new Purchase();
        purchase.setCustomerId(dto.customerId());
        purchase.setProductId(dto.productId());
        purchase.setProductName(dto.productName());
        purchase.setProductType(dto.productType());
        purchase.setPrice(dto.price());
        purchase.setPurchaseDate(LocalDateTime.now());

        Purchase savedPurchase = purchaseRepository.save(purchase);
        return toResponseDTO(savedPurchase);
    }

    @Override
    public List<PurchaseResponseDTO> findAll(){
        return purchaseRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public PurchaseResponseDTO findById(String id) {
        Purchase purchase = purchaseRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Compra não encontrada com id: " + id));

        return toResponseDTO(purchase);
    }

    @Override
    public List<PurchaseResponseDTO> findByCustomerId(String customerId) {
        return purchaseRepository.findByCustomerId(customerId)
        .stream().map(this::toResponseDTO).toList();
    }

    @Override
    public void delete(String id) {
        Purchase purchase = purchaseRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Compra não identificada com id: " + id));

        purchaseRepository.delete(purchase);
    }

    private PurchaseResponseDTO toResponseDTO(Purchase purchase) {
        return new PurchaseResponseDTO(
            purchase.getId(),
            purchase.getCustomerId(),
            purchase.getProductId(),
            purchase.getProductName(),
            purchase.getProductType(),
            purchase.getPrice(),
            purchase.getPurchaseDate()
        );
    }
}
