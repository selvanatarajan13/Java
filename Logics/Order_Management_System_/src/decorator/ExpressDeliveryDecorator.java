package decorator;

import model.product.Product;

public class ExpressDeliveryDecorator extends ProductDecorator {

    private static final double EXPRESS_CHARGE = 100.0;

    public ExpressDeliveryDecorator(Product product) {
        super(product);
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + EXPRESS_CHARGE;
    }

    @Override
    public String toString() {
        return wrappedProduct.toString() + " + ExpressDelivery(₹100)";
    }
}
