package model.product;

import enums.ProductCategory;

public abstract class Product {
    private String productId;
    private String productName;
    private double basePrice;
    private ProductCategory category;

    public Product(String productId, String productName, double basePrice, ProductCategory category) {
        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
        this.category = category;
    }

    // Force every subclass to define its own discount
    public abstract double getDiscount();

    public double getFinalPrice() {
        // getDiscount() calls the subclass version automatically!
        return this.basePrice * (1 - getDiscount()/100);
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public ProductCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
