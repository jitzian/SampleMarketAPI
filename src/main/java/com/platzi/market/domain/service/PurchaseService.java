package com.platzi.market.domain.service;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDTO> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDTO save(PurchaseDTO purchase) {
        return purchaseRepository.save(purchase);
    }
}
