package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByIdCliente(String idCliente);
}
