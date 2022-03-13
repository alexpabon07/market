package com.alexpabon07.market.domain.repository;

import com.alexpabon07.market.domain.ProductD;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryD {

    List<ProductD> getAll();
    Optional<List<ProductD>> getByCategory(int categoryId);
    Optional<List<ProductD>> getScarseProducts(int quantity);
    Optional<ProductD> getProduct(int productId);
    ProductD save(ProductD product);
    void delete(int productId);
}
