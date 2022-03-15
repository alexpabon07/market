package com.alexpabon07.market.domain.service;

import com.alexpabon07.market.domain.ProductD;
import com.alexpabon07.market.domain.repository.ProductRepositoryD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryD productRepository;

    public List<ProductD> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductD> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductD>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductD save(ProductD productD) {
        return productRepository.save(productD);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(productD -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        /*
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
        */
    }
}
