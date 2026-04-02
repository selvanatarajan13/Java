package model.product;

import enums.ProductCategory;

public class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(String productId, String productName, double basePrice, String size, String color) {
        super(productId, productName, basePrice, ProductCategory.CLOTHING);
        this.size = size;
        this.color = color;
    }

    @Override
    public double getDiscount() {
        return 20;
    }
}
