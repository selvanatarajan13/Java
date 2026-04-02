package model.product;

import enums.ProductCategory;

public class Electronics extends Product {
    private String brand;
    private int warranty;

    public Electronics(String productId, String productName, double basePrice, String brand, int warranty) {
        super(productId, productName, basePrice, ProductCategory.ELECTRONICS);
        this.warranty = warranty;
        this.brand = brand;
    }

    @Override
    public double getDiscount() {
        return 10;
    }
}
