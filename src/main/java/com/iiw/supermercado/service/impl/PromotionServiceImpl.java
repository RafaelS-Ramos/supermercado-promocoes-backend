package com.iiw.supermercado.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iiw.supermercado.dto.promotion.PromotionCreateDTO;
import com.iiw.supermercado.dto.promotion.PromotionResponseDTO;
import com.iiw.supermercado.dto.promotion.PromotionUpdateDTO;
import com.iiw.supermercado.exception.ResourceNotFoundException;
import com.iiw.supermercado.model.Promotion;
import com.iiw.supermercado.model.Purchase;
import com.iiw.supermercado.repository.PromotionRepository;
import com.iiw.supermercado.repository.PurchaseRepository;
import com.iiw.supermercado.service.PromotionService;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PromotionServiceImpl implements PromotionService{
    private final PromotionRepository promotionRepository;
    private final PurchaseRepository purchaseRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository, PurchaseRepository purchaseRepository){
        this.promotionRepository = promotionRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PromotionResponseDTO create(PromotionCreateDTO dto) {
        Promotion promotion = new Promotion();
        promotion.setTitle(dto.title());
        promotion.setDescription(dto.description());
        promotion.setDiscountPercentage(dto.discountPercentage());
        promotion.setProductType(dto.productType());
        promotion.setProductId(dto.productId());
        promotion.setCustomerId(dto.customerId());
        promotion.setStartDate(dto.startDate());
        promotion.setEndDate(dto.endDate());
        promotion.setActive(dto.active());

        Promotion savedPromotion = promotionRepository.save(promotion);
        return toResponseDTO(savedPromotion);
    }

    @Override
    public List<PromotionResponseDTO> findAll() {
        return promotionRepository
        .findAll()
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }

    @Override
    public PromotionResponseDTO findById(String id) {
        Promotion promotion = promotionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Promoção não encontrado com id: " + id));

        return toResponseDTO(promotion);
    }

    @Override
    public PromotionResponseDTO update(String id, PromotionUpdateDTO dto) {
        Promotion promotion = promotionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Promoção não encontrado ocm id: " + id));

        promotion.setTitle(dto.title());
        promotion.setDescription(dto.description());
        promotion.setDiscountPercentage(dto.discountPercentage());
        promotion.setProductType(dto.productType());
        promotion.setProductId(dto.productId());
        promotion.setCustomerId(dto.customerId());
        promotion.setStartDate(dto.startDate());
        promotion.setEndDate(dto.endDate());
        promotion.setActive(dto.active());

        Promotion updatePromotion = promotionRepository.save(promotion);
        return toResponseDTO(updatePromotion);
    }

    @Override
    public void delete(String id) {
        Promotion promotion = promotionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Promoção não encontrado com o id: " + id));

        promotionRepository.delete(promotion);
    }

    @Override
    public List<PromotionResponseDTO> findPromotionsForCustomer(String customerId) {
        List<Purchase> purchases = purchaseRepository.findByCustomerId(customerId);

        String favoriteType = purchases
        .stream()
        .collect(Collectors
        .groupingBy(Purchase::getProductType,Collectors
        .counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);

        List<Promotion> customerPromotions = promotionRepository.findByCustomerIdIsNullAndProductTypeIsNullAndActiveTrue();

        List<Promotion> typePromotions = favoriteType != null
            ? promotionRepository.findByProductTypeAndActiveTrue(favoriteType)
            : List.of();

        List<Promotion> generalPromotions = promotionRepository.findByCustomerIdIsNullAndProductTypeIsNullAndActiveTrue();

        Map<String, Promotion> uniquePromotions = new LinkedHashMap<>();

        customerPromotions.forEach(promotion -> uniquePromotions.put(promotion.getId(), promotion));
        typePromotions.forEach(promotion -> uniquePromotions.put(promotion.getId(), promotion));
        generalPromotions.forEach(promotion -> uniquePromotions.put(promotion.getId(), promotion));

        return uniquePromotions
        .values()
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }
    
    private PromotionResponseDTO toResponseDTO(Promotion promotion) {
        return new PromotionResponseDTO(
            promotion.getId(),
            promotion.getTitle(),
            promotion.getDescription(),
            promotion.getDiscountPercentage(),
            promotion.getProductType(),
            promotion.getProductId(),
            promotion.getCustomerId(),
            promotion.getStartDate(),
            promotion.getEndDate(),
            promotion.getActive()
        );
    }
}