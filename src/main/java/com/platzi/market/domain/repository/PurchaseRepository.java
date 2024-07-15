package com.platzi.market.domain.repository;

import com.platzi.market.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);
}
