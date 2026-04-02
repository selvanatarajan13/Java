package decorator;

import model.product.Product;

public class GiftWrapDecorator extends ProductDecorator {

    private static final double GIFT_WRAP_CHARGE = 50.0;

    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + GIFT_WRAP_CHARGE;
    }

    @Override
    public String toString() {
        return wrappedProduct.toString() + " + GiftWrap(₹50)";
    }
}
