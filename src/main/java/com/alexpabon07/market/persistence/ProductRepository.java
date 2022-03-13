package com.alexpabon07.market.persistence;

import com.alexpabon07.market.domain.ProductD;
import com.alexpabon07.market.domain.repository.ProductRepositoryD;
import com.alexpabon07.market.persistence.crud.ProductCrudRepository;
import com.alexpabon07.market.persistence.entity.Product;
import com.alexpabon07.market.persistence.mapper.CategoryMapper;
import com.alexpabon07.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryD {

    private ProductCrudRepository productCrudRepository;
    private ProductMapper productMapper;
    private CategoryMapper categoryMapper;

    @Override
    public List<ProductD> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    public Optional<ProductD> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(prod -> productMapper.toProduct(prod));
    }

    public Optional<List<ProductD>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductD>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndEstatus(quantity, true);
        return products.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public ProductD save(ProductD productD) {
        Product product = productMapper.toProductD(productD);
        return productMapper.toProduct(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
