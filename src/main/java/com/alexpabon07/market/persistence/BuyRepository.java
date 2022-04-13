package com.alexpabon07.market.persistence;

import com.alexpabon07.market.domain.Purchase;
import com.alexpabon07.market.domain.repository.PurchaseRepository;
import com.alexpabon07.market.persistence.crud.BuyCrudRepository;
import com.alexpabon07.market.persistence.entity.Buy;
import com.alexpabon07.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements PurchaseRepository {

    @Autowired
    private BuyCrudRepository buyCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Buy>) buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String idClient) {
        return buyCrudRepository.findByIdClient(idClient)
                .map(buyList -> purchaseMapper.toPurchases(buyList));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Buy buy = purchaseMapper.toBuy(purchase);
        buy.getProducts().forEach(buyProduct -> buyProduct.setBuy(buy));
        return purchaseMapper.toPurchase(buyCrudRepository.save(buy));
    }
}
