package com.iiw.supermercado.service;

import java.util.List;

import com.iiw.supermercado.dto.purchase.PurchaseCreateDTO;
import com.iiw.supermercado.dto.purchase.PurchaseResponseDTO;

public interface PurchaseService {
    PurchaseResponseDTO create(PurchaseCreateDTO dto);

    List<PurchaseResponseDTO> findAll();

    PurchaseResponseDTO findById(String id);

    List<PurchaseResponseDTO> findByCustomerId(String customerId);

    void delete(String id);
}