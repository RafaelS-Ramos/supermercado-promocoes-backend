package com.iiw.supermercado.service;

import java.util.List;
import com.iiw.supermercado.dto.promotion.PromotionCreateDTO;
import com.iiw.supermercado.dto.promotion.PromotionResponseDTO;
import com.iiw.supermercado.dto.promotion.PromotionUpdateDTO;

public interface PromotionService {
    PromotionResponseDTO create(PromotionCreateDTO dto);

    List<PromotionResponseDTO> findAll();
    
    PromotionResponseDTO findById(String id);
    
    PromotionResponseDTO update(String id, PromotionUpdateDTO dto);

    void delete(String id);

    List<PromotionResponseDTO> findPromotionsForCustomer(String customerId);
}