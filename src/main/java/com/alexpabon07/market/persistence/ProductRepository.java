package com.alexpabon07.market.persistence;

import com.alexpabon07.market.persistence.crud.ProductCrudRepository;
import com.alexpabon07.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product> getProduct(int idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
    
    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getLowProducts(int stockQuantity) {
        return productCrudRepository.findByStockQuantityLessThanAndEstatus(stockQuantity, true);
    }
}
