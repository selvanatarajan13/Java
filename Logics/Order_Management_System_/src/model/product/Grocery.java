package model.product;

import enums.ProductCategory;

public class Grocery extends Product {
    private String expiryDate;
    private String brand;

    public Grocery(String productId, String productName,
                   double basePrice, String brand, String expiryDate) {
        super(productId, productName, basePrice, ProductCategory.GROCERY);
        this.brand      = brand;
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
    public String getBrand()      { return brand; }

    @Override
    public double getDiscount() {
        return 5.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" [Brand: %s, Expiry: %s]", brand, expiryDate);
    }
}
