package com.alexpabon07.market.domain;

public class ProductD {

    private int productId;
    private String nameProduct;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private CategoryD categoryD;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryD getCategoryD() {
        return categoryD;
    }

    public void setCategoryD(CategoryD categoryD) {
        this.categoryD = categoryD;
    }
}
