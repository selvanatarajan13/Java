package decorator;

import enums.ProductCategory;
import model.product.Product;

public abstract class ProductDecorator extends Product {

    protected Product wrappedProduct;

    public ProductDecorator(Product product) {
        super(product.getProductId(), product.getProductName(), product.getBasePrice(), product.getCategory());
        this.wrappedProduct = product;
    }

    @Override
    public double getDiscount() {
        return wrappedProduct.getDiscount();
    }

    @Override
    public double getFinalPrice() {
        return wrappedProduct.getFinalPrice();
    }
}
