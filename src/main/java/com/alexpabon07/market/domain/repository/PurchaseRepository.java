package com.alexpabon07.market.domain.repository;

import com.alexpabon07.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String idClient);
    Purchase save(Purchase purchase);
}
