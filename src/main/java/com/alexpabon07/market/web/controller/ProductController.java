package com.alexpabon07.market.web.controller;

import com.alexpabon07.market.domain.ProductD;
import com.alexpabon07.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductD> getAll() {
        return productService.getAll();
    }

    @GetMapping("/product/{productId}")
    public Optional<ProductD> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductD>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public ProductD save(@RequestBody ProductD productD) {
        return productService.save(productD);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId) {
        return productService.delete(productId);
    }
}
